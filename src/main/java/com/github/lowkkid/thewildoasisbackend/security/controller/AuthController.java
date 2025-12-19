package com.github.lowkkid.thewildoasisbackend.security.controller;

import com.github.lowkkid.thewildoasisbackend.security.model.TokensResponse;
import com.github.lowkkid.thewildoasisbackend.security.model.UsernameAndPassword;
import com.github.lowkkid.thewildoasisbackend.security.model.RefreshRequest;
import com.github.lowkkid.thewildoasisbackend.security.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "Sign in as an existing user")
    @PostMapping("/login")
    public ResponseEntity<TokensResponse> login(@RequestBody @Valid UsernameAndPassword usernameAndPassword) {
        var tokensResponse = authService.login(usernameAndPassword);
        return ResponseEntity.ok(tokensResponse);
    }

    @Operation(summary = "Get new pair of tokens (access + refresh) " +
            "based on non-expired and non-revoked refresh token and expired access token (used for decoding userId)")
    @PostMapping("/refresh")
    public ResponseEntity<TokensResponse> login(@RequestAttribute RefreshRequest refreshRequest) {
        System.out.println(refreshRequest);
        var tokensResponse = authService.refreshToken(refreshRequest);
        return ResponseEntity.ok(tokensResponse);
    }
}