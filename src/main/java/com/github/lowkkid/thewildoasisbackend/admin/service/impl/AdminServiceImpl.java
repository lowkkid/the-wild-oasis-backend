package com.github.lowkkid.thewildoasisbackend.admin.service.impl;

import com.github.lowkkid.thewildoasisbackend.security.model.UserDTO;
import com.github.lowkkid.thewildoasisbackend.security.model.UsernameAndPassword;
import com.github.lowkkid.thewildoasisbackend.security.model.enums.UserRole;
import com.github.lowkkid.thewildoasisbackend.admin.service.AdminService;
import com.github.lowkkid.thewildoasisbackend.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserService userService;

    @Override
    public Page<UserDTO> getAll(
            UserRole role, Integer pageNumber, Integer pageSize, String sortField, Sort.Direction sortDirection) {
        return userService.findAllDtoByRole(
                role, pageNumber, pageSize, sortField, sortDirection);
    }

    @Override
    public void createEmployee(UsernameAndPassword usernameAndPassword) {
        userService.createEmployee(usernameAndPassword);
    }
}
