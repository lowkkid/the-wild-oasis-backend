package com.github.lowkkid.thewildoasisbackend.admin.service;

import com.github.lowkkid.thewildoasisbackend.security.model.UserDTO;
import com.github.lowkkid.thewildoasisbackend.security.model.UsernameAndPassword;
import com.github.lowkkid.thewildoasisbackend.security.model.enums.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface AdminService {

    Page<UserDTO> getAll(
            UserRole role, Integer pageNumber, Integer pageSize, String sortField, Sort.Direction sortDirection);
    
    void createEmployee(UsernameAndPassword usernameAndPassword);
}
