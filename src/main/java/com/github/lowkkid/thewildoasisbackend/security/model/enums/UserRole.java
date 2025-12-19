package com.github.lowkkid.thewildoasisbackend.security.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
@Getter
public enum UserRole implements GrantedAuthority {
    EMPLOYEE("employee"), ADMIN("admin");

    private final String value;

    @Override
    public String getAuthority() {
        return toString();
    }


    @Override
    public String toString() {
        return value;
    }
}
