package com.github.lowkkid.thewildoasisbackend.service;

import com.github.lowkkid.thewildoasisbackend.security.model.UsernameAndPassword;

public interface AdminService {
    
    void createEmployee(UsernameAndPassword usernameAndPassword);
}
