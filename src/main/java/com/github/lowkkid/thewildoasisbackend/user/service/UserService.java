package com.github.lowkkid.thewildoasisbackend.user.service;

import com.github.lowkkid.thewildoasisbackend.user.model.UserDTO;
import com.github.lowkkid.thewildoasisbackend.user.model.UsernameAndPassword;
import com.github.lowkkid.thewildoasisbackend.user.model.UserRole;
import com.github.lowkkid.thewildoasisbackend.user.model.UpdatePasswordRequest;
import com.github.lowkkid.thewildoasisbackend.user.model.UpdateUserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.UUID;

public interface UserService {

    void createEmployee(UsernameAndPassword usernameAndPassword);

    Page<UserDTO> findAllDtoByRole(
            UserRole role, Integer pageNumber, Integer pageSize, String sortField, Sort.Direction sortDirection);

    void update(UUID id, UpdateUserRequest updateUserRequest);

    void updatePassword(UUID id, UpdatePasswordRequest updatePasswordRequest);

    void deleteEmployee(UUID id);
}
