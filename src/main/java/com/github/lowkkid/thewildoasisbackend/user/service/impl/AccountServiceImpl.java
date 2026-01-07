package com.github.lowkkid.thewildoasisbackend.user.service.impl;

import com.github.lowkkid.thewildoasisbackend.security.utils.AuthUtils;
import com.github.lowkkid.thewildoasisbackend.user.model.UpdatePasswordRequest;
import com.github.lowkkid.thewildoasisbackend.user.model.UpdateUserRequest;
import com.github.lowkkid.thewildoasisbackend.user.service.AccountService;
import com.github.lowkkid.thewildoasisbackend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AuthUtils authUtils;
    private final UserService userService;

    @Override
    public void update(UpdateUserRequest request) {
        var authenticatedUserId = authUtils.getAuthenticatedUserId();
        userService.update(authenticatedUserId, request);
    }

    @Override
    public void updatePassword(UpdatePasswordRequest request) {
        var authenticatedUserId = authUtils.getAuthenticatedUserId();
        userService.updatePassword(authenticatedUserId, request);
    }
}
