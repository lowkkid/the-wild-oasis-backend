package com.github.lowkkid.lodgecore.user.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserDTO(UUID id,
                      String username,
                      UserRole role,
                      LocalDateTime createdAt) {
}
