package com.github.lowkkid.thewildoasisbackend.user.model;

import org.springframework.web.multipart.MultipartFile;

public record UpdateUserRequest(String username, MultipartFile avatar) {}
