package com.github.lowkkid.thewildoasisbackend.security.model;

import jakarta.validation.constraints.NotNull;

public record UsernameAndPassword(@NotNull String username, @NotNull String password) {
}
