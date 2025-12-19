package com.github.lowkkid.thewildoasisbackend.security.service;

import com.github.lowkkid.thewildoasisbackend.security.model.RefreshRequest;

import java.util.UUID;

public interface RefreshTokenService {

    String generateRefreshToken(UUID userId);
    String refresh(RefreshRequest refreshRequest);
}
