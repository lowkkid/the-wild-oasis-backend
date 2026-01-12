package com.github.lowkkid.lodgecore.user.model;

public record UpdatePasswordRequest(String oldPassword, String newPassword) {
}
