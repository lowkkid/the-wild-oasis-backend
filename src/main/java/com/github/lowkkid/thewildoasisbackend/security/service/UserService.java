package com.github.lowkkid.thewildoasisbackend.security.service;

import com.github.lowkkid.thewildoasisbackend.domain.entity.User;
import com.github.lowkkid.thewildoasisbackend.security.model.UserDTO;
import com.github.lowkkid.thewildoasisbackend.security.model.UsernameAndPassword;
import com.github.lowkkid.thewildoasisbackend.security.model.enums.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.UUID;

public interface UserService {

    Page<User> findAllByRole(
            UserRole role, Integer pageNumber, Integer pageSize, String sortField, Sort.Direction sortDirection);

    Page<UserDTO> findAllDtoByRole(
            UserRole role, Integer pageNumber, Integer pageSize, String sortField, Sort.Direction sortDirection);

    void createEmployee(UsernameAndPassword usernameAndPassword);

    void deleteEmployee(UUID id);
}
