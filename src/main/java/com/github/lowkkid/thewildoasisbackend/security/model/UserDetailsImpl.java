package com.github.lowkkid.thewildoasisbackend.security.model;

import com.github.lowkkid.thewildoasisbackend.security.model.enums.UserRole;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
@ToString
public class UserDetailsImpl implements UserDetails {

    private final String username;
    private final String password;
    private final UserRole role;
    private final UUID userId;

    public UserDetailsImpl(String username, UserRole role, UUID userId) {
        this.role = role;
        this.password = "";
        this.userId = userId;
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(role);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
