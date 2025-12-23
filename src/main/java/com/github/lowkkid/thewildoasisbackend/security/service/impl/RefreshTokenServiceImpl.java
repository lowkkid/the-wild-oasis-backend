package com.github.lowkkid.thewildoasisbackend.security.service.impl;

import com.github.lowkkid.thewildoasisbackend.domain.entity.RefreshToken;
import com.github.lowkkid.thewildoasisbackend.security.repository.RefreshTokenRepository;
import com.github.lowkkid.thewildoasisbackend.security.repository.UserRepository;
import com.github.lowkkid.thewildoasisbackend.exception.TokenException;
import com.github.lowkkid.thewildoasisbackend.security.model.RefreshRequest;
import com.github.lowkkid.thewildoasisbackend.security.service.RefreshTokenService;
import com.github.lowkkid.thewildoasisbackend.security.TokenExpirationTimeUtils;
import jakarta.transaction.Transactional;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private static final int REFRESH_TOKEN_LENGTH = 72;
    private static final int BCRYPT_COST_FACTOR = 10;

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;
    private final TokenExpirationTimeUtils tokenExpirationTimeUtils;

    @Override
    @Transactional
    public String generateRefreshToken(UUID userId) {
        //delete previous refresh token
        var userProxy = userRepository.getReferenceById(userId);
        refreshTokenRepository.findByUser(userProxy).ifPresent(refreshTokenRepository::delete);

        byte[] tokenBytes = new byte[REFRESH_TOKEN_LENGTH];
        SECURE_RANDOM.nextBytes(tokenBytes);
        String token = Base64.getEncoder().encodeToString(tokenBytes);


        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(userProxy);

        String salt = BCrypt.gensalt(BCRYPT_COST_FACTOR, SECURE_RANDOM);
        String tokenHash = BCrypt.hashpw(token, salt);
        refreshToken.setTokenHash(tokenHash);

        LocalDateTime issuedAt = LocalDateTime.now();
        refreshToken.setIssuedAt(issuedAt);
        refreshToken.setExpiresAt(tokenExpirationTimeUtils.getRefreshTokenExpirationTime(issuedAt));
        refreshToken.setExpiresAbsolute(tokenExpirationTimeUtils.getRefreshTokenAbsoluteExpirationTime(issuedAt));

        refreshTokenRepository.save(refreshToken);
        return token;
    }

    @Override
    public String refresh(RefreshRequest refreshRequest) {
        var userId = refreshRequest.userDetails().getUserId();
        var tokenFromDb = refreshTokenRepository.findByUserId(userId)
                .orElseThrow(() -> new TokenException("Refresh token for user " + userId + " not found"));

        var refreshToken = refreshRequest.refreshToken();
        if (!BCrypt.checkpw(refreshToken, tokenFromDb.getTokenHash())) {
            throw new TokenException("Invalid refresh token");
        }

        if (!tokenFromDb.isValid()) {
            throw new TokenException("Refresh token expired, please login again");
        }

        // if everything ok - delete old token and create new one
        RefreshToken newRefreshToken = new RefreshToken();
        newRefreshToken.setUser(tokenFromDb.getUser());
        var now = LocalDateTime.now();
        newRefreshToken.setIssuedAt(now);
        newRefreshToken.setExpiresAt(tokenExpirationTimeUtils.getRefreshTokenExpirationTime(now));
        newRefreshToken.setExpiresAbsolute(tokenFromDb.getExpiresAbsolute());

        byte[] tokenBytes = new byte[REFRESH_TOKEN_LENGTH];
        SECURE_RANDOM.nextBytes(tokenBytes);
        String token = Base64.getEncoder().encodeToString(tokenBytes);

        String salt = BCrypt.gensalt(BCRYPT_COST_FACTOR, SECURE_RANDOM);
        String tokenHash = BCrypt.hashpw(token, salt);
        newRefreshToken.setTokenHash(tokenHash);

        refreshTokenRepository.delete(tokenFromDb);
        refreshTokenRepository.save(newRefreshToken);
        return token;
    }

}

