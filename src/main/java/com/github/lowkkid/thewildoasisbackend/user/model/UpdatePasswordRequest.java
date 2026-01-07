package com.github.lowkkid.thewildoasisbackend.user.model;

public record UpdatePasswordRequest(String oldPassword, String newPassword) {
}
