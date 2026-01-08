package com.github.lowkkid.thewildoasisbackend.user.model;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record UpdateUserRequest(@NotNull String username, MultipartFile avatar) {}
