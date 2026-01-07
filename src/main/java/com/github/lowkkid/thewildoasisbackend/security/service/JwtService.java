package com.github.lowkkid.thewildoasisbackend.security.service;

import com.github.lowkkid.thewildoasisbackend.security.model.JwtValidationResult;
import com.github.lowkkid.thewildoasisbackend.user.model.UserRole;
import com.github.lowkkid.thewildoasisbackend.security.model.UserDetailsImpl;
import io.jsonwebtoken.Claims;

import java.util.UUID;

public interface JwtService {

    String generate(UUID userId, UserRole role, String username, String avatar);

    String generate(UserDetailsImpl userDetails);

    JwtValidationResult validate(String token);

    Claims extractAllClaims(String token);
}
