package com.github.lowkkid.thewildoasisbackend.security.service;

import com.github.lowkkid.thewildoasisbackend.security.model.TokensResponse;
import com.github.lowkkid.thewildoasisbackend.security.model.UsernameAndPassword;
import com.github.lowkkid.thewildoasisbackend.security.model.RefreshRequest;

public interface AuthService {

    TokensResponse login(UsernameAndPassword usernameAndPassword);

    TokensResponse refreshToken(RefreshRequest refreshRequest);
}
