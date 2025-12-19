package com.github.lowkkid.thewildoasisbackend.security.controller;

import com.github.lowkkid.thewildoasisbackend.security.model.enums.UserRole;
import com.github.lowkkid.thewildoasisbackend.security.model.UserDetailsImpl;
import com.github.lowkkid.thewildoasisbackend.security.model.RefreshRequest;
import com.github.lowkkid.thewildoasisbackend.security.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RefreshRequestParser implements HandlerInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";
    private static final String REFRESH_TOKEN_HEADER = "X-Refresh-Token";

    private final JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        var refreshToken = request.getHeader(REFRESH_TOKEN_HEADER);

        var authHeader = request.getHeader(AUTHORIZATION_HEADER);

        if (refreshToken == null || authHeader == null || !authHeader.startsWith(BEARER_PREFIX)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");

            response.getWriter()
                    .write("{\"error\": \"Both access and refresh tokens should be provided for this request\"}");
            return false;
        }

        var jwt = authHeader.substring(BEARER_PREFIX.length());
        var claims = jwtService.extractAllClaims(jwt);
        var userId = claims.getSubject();
        var username = claims.get("username", String.class);
        var role =  UserRole.valueOf(claims.get("role", String.class));

        var userDetails = new UserDetailsImpl(username, role,UUID.fromString(userId));
        var refreshRequest = new RefreshRequest(userDetails, refreshToken);
        request.setAttribute("refreshRequest", refreshRequest);
        return true;
    }
}
