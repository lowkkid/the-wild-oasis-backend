package com.github.lowkkid.thewildoasisbackend.controller;

import com.github.lowkkid.thewildoasisbackend.security.model.UsernameAndPassword;
import com.github.lowkkid.thewildoasisbackend.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @Operation(summary = "Create new employee (admin only)")
    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/employee")
    public ResponseEntity<Void> createEmployee(@RequestBody @Valid UsernameAndPassword usernameAndPassword) {
        adminService.createEmployee(usernameAndPassword);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
