package com.github.lowkkid.thewildoasisbackend.service.impl;

import com.github.lowkkid.thewildoasisbackend.domain.entity.User;
import com.github.lowkkid.thewildoasisbackend.security.repository.UserRepository;
import com.github.lowkkid.thewildoasisbackend.exception.AlreadyExistsException;
import com.github.lowkkid.thewildoasisbackend.security.model.UsernameAndPassword;
import com.github.lowkkid.thewildoasisbackend.security.model.enums.UserRole;
import com.github.lowkkid.thewildoasisbackend.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createEmployee(UsernameAndPassword usernameAndPassword) {
        var username = usernameAndPassword.username();
        var password = usernameAndPassword.password();
        if (userRepository.existsByUsername(username)) {
            throw new AlreadyExistsException("Employee with this username already exists");
        }
        var user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(UserRole.EMPLOYEE);

        userRepository.save(user);
    }
}
