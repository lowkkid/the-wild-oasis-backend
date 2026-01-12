package com.github.lowkkid.lodgecore.user.service.impl;

import com.github.lowkkid.lodgecore.security.service.JwtService;
import com.github.lowkkid.lodgecore.security.utils.AuthUtils;
import com.github.lowkkid.lodgecore.user.model.UpdatePasswordRequest;
import com.github.lowkkid.lodgecore.user.model.UpdateUserRequest;
import com.github.lowkkid.lodgecore.user.service.AccountService;
import com.github.lowkkid.lodgecore.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AuthUtils authUtils;
    private final UserService userService;
    private final JwtService jwtService;

    @Override
    public String update(UpdateUserRequest request) {
        var authenticatedUserId = authUtils.getAuthenticatedUserId();
        var updatedUser = userService.update(authenticatedUserId, request);
        return jwtService.generate(
                updatedUser.getId(), updatedUser.getRole(), updatedUser.getUsername(), updatedUser.getAvatar());
    }

    @Override
    public void updatePassword(UpdatePasswordRequest request) {
        var authenticatedUserId = authUtils.getAuthenticatedUserId();
        userService.updatePassword(authenticatedUserId, request);
    }
}
