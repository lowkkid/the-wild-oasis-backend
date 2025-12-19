package com.github.lowkkid.thewildoasisbackend.exception;

import org.springframework.security.core.AuthenticationException;

public class TokenException extends AuthenticationException {

    public TokenException(String msg) {
        super(msg);
    }
}
