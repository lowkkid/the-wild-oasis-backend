package com.github.lowkkid.thewildoasisbackend.user.service;

import com.github.lowkkid.thewildoasisbackend.user.model.UpdatePasswordRequest;
import com.github.lowkkid.thewildoasisbackend.user.model.UpdateUserRequest;

public interface AccountService {

    String update(UpdateUserRequest request);
    void updatePassword(UpdatePasswordRequest request);
}
