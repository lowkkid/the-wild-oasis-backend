package com.github.lowkkid.thewildoasisbackend.user.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserDTO(UUID id,
                      String username,
                      UserRole role,
                      LocalDateTime createdAt) {
}
