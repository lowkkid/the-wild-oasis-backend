package com.github.lowkkid.thewildoasisbackend.security.model;

import io.swagger.v3.oas.annotations.media.Schema;

public record TokensResponse(
        @Schema(description = "JWT access token")
        String jwtToken,
        @Schema(description = "Refresh token")
        String refreshToken
) {}