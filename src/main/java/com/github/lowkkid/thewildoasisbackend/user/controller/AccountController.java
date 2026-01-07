package com.github.lowkkid.thewildoasisbackend.user.controller;

import com.github.lowkkid.thewildoasisbackend.user.model.UpdatePasswordRequest;
import com.github.lowkkid.thewildoasisbackend.user.model.UpdateUserRequest;
import com.github.lowkkid.thewildoasisbackend.user.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> update(@ModelAttribute UpdateUserRequest request) {
        accountService.update(request);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/password")
    public ResponseEntity<Void> updatePassword(@RequestBody UpdatePasswordRequest request) {
        accountService.updatePassword(request);
        return ResponseEntity.noContent().build();
    }
}
