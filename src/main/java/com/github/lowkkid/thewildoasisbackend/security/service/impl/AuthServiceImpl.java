package com.github.lowkkid.thewildoasisbackend.security.service.impl;

import com.github.lowkkid.thewildoasisbackend.security.model.TokensResponse;
import com.github.lowkkid.thewildoasisbackend.security.model.UsernameAndPassword;
import com.github.lowkkid.thewildoasisbackend.security.model.UserDetailsImpl;
import com.github.lowkkid.thewildoasisbackend.security.model.RefreshRequest;
import com.github.lowkkid.thewildoasisbackend.security.service.AuthService;
import com.github.lowkkid.thewildoasisbackend.security.service.JwtService;
import com.github.lowkkid.thewildoasisbackend.security.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;

    @Override
    @Transactional
    public TokensResponse login(UsernameAndPassword usernameAndPassword) {
        var username = usernameAndPassword.username();
        var password = usernameAndPassword.password();

        var authToken = new UsernamePasswordAuthenticationToken(username, password);

        var authentication = authenticationManager.authenticate(authToken);

        var userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwt = jwtService.generateToken(userDetails);
        String refreshToken = refreshTokenService.generateRefreshToken(userDetails.getUserId());


        return new TokensResponse(jwt, refreshToken);
    }

    @Override
    @Transactional
    public TokensResponse refreshToken(RefreshRequest refreshRequest) {
        var newRefreshToken = refreshTokenService.refresh(refreshRequest);
        var newJwtToken = jwtService.generateToken(refreshRequest.userDetails());

        return new TokensResponse(newJwtToken, newRefreshToken);
    }
}
