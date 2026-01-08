package com.github.lowkkid.thewildoasisbackend.user.service.impl;

import com.github.lowkkid.thewildoasisbackend.user.domain.entity.User;
import com.github.lowkkid.thewildoasisbackend.common.exception.AlreadyExistsException;
import com.github.lowkkid.thewildoasisbackend.user.mapper.UserMapper;
import com.github.lowkkid.thewildoasisbackend.user.model.UserDTO;
import com.github.lowkkid.thewildoasisbackend.user.model.UsernameAndPassword;
import com.github.lowkkid.thewildoasisbackend.user.model.UserRole;
import com.github.lowkkid.thewildoasisbackend.user.domain.repository.UserRepository;
import com.github.lowkkid.thewildoasisbackend.minio.service.MinioService;
import com.github.lowkkid.thewildoasisbackend.user.model.UpdatePasswordRequest;
import com.github.lowkkid.thewildoasisbackend.user.model.UpdateUserRequest;
import com.github.lowkkid.thewildoasisbackend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String USER_AVATARS_PREFIX = "user-avatars/";


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final MinioService minioService;

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
    public Page<UserDTO> findAllDtoByRole(UserRole role, Integer pageNumber, Integer pageSize, String sortField, Sort.Direction sortDirection) {
        return userRepository.findAllByRole(
                role, PageRequest.of(--pageNumber, pageSize, Sort.by(sortDirection, sortField))).map(userMapper::toUserDTO);
    }

    @Override
    @Transactional
    public User update(UUID id, UpdateUserRequest updateUserRequest) {
        var user = getById(id);
        user.setUsername(updateUserRequest.username());

        if (updateUserRequest.avatar() != null) {
            minioService.deleteFile(USER_AVATARS_PREFIX + user.getUsername());

            var newAvatar = minioService.uploadFile(updateUserRequest.avatar(),
                    USER_AVATARS_PREFIX + updateUserRequest.username());
            user.setAvatar(newAvatar);
        }

        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void updatePassword(UUID id, UpdatePasswordRequest updatePasswordRequest) {
        var user = getById(id);

        if (!BCrypt.checkpw(updatePasswordRequest.oldPassword(), user.getPassword())) {
            throw new BadCredentialsException("Old password is incorrect");
        }

        var newEncodedPassword = passwordEncoder.encode(updatePasswordRequest.newPassword());
        user.setPassword(newEncodedPassword);
    }

    @Override
    public void deleteEmployee(UUID id) {
        var user = getById(id);

        if (user.getRole() != UserRole.EMPLOYEE) {
            throw new AccessDeniedException("You can't delete non-employee user");
        }

        userRepository.delete(user);
    }

    private User getById(UUID id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User with id " + id + " not found"));
    }
}
