package com.github.lowkkid.thewildoasisbackend.security.model;

public record RefreshRequest(UserDetailsImpl userDetails, String refreshToken) {
}
