package com.github.lowkkid.thewildoasisbackend.security.service.impl;

import com.github.lowkkid.thewildoasisbackend.domain.entity.User;
import com.github.lowkkid.thewildoasisbackend.exception.AlreadyExistsException;
import com.github.lowkkid.thewildoasisbackend.security.mapper.UserMapper;
import com.github.lowkkid.thewildoasisbackend.security.model.UserDTO;
import com.github.lowkkid.thewildoasisbackend.security.model.UsernameAndPassword;
import com.github.lowkkid.thewildoasisbackend.security.model.enums.UserRole;
import com.github.lowkkid.thewildoasisbackend.security.repository.UserRepository;
import com.github.lowkkid.thewildoasisbackend.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public Page<User> findAllByRole(UserRole role, Integer pageNumber, Integer pageSize, String sortField, Sort.Direction sortDirection) {
        return userRepository.findAllByRole(
                role, PageRequest.of(--pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Page<UserDTO> findAllDtoByRole(UserRole role, Integer pageNumber, Integer pageSize, String sortField, Sort.Direction sortDirection) {
        return findAllByRole(role, pageNumber, pageSize, sortField, sortDirection).map(userMapper::toUserDTO);
    }

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

    @Override
    public void deleteEmployee(UUID id) {
        var user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User with id " + id + " not found"));

        if (user.getRole() != UserRole.EMPLOYEE) {
            throw new AccessDeniedException("You can't delete non-employee user");
        }

        userRepository.delete(user);
    }
}
