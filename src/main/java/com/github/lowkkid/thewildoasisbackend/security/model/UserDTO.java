package com.github.lowkkid.thewildoasisbackend.security.model;

import com.github.lowkkid.thewildoasisbackend.security.model.enums.UserRole;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserDTO(UUID id,
                      String username,
                      UserRole role,
                      LocalDateTime createdAt) {
}
