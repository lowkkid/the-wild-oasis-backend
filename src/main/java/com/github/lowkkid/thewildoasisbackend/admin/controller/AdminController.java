package com.github.lowkkid.thewildoasisbackend.admin.controller;

import com.github.lowkkid.thewildoasisbackend.security.model.UserDTO;
import com.github.lowkkid.thewildoasisbackend.security.model.UsernameAndPassword;
import com.github.lowkkid.thewildoasisbackend.security.model.enums.UserRole;
import com.github.lowkkid.thewildoasisbackend.admin.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @Operation(summary = "Delete employee (admin only)")
    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID id) {
        adminService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get all users (admin only)")
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/users")
    public ResponseEntity<Page<UserDTO>> getUsers(@RequestParam(required = false) UserRole role,
                                                  @RequestParam(defaultValue = "1") Integer pageNumber,
                                                  @RequestParam(defaultValue = "10" ) Integer pageSize,
                                                  @RequestParam(defaultValue = "createdAt") String sortField,
                                                  @RequestParam(defaultValue = "DESC") Sort.Direction sortDirection) {
        var res = adminService.getAll(role, pageNumber, pageSize, sortField, sortDirection);
        return ResponseEntity.ok(res);
    }
}
