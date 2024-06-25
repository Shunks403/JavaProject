package com.example.demo.web.controller;

import com.example.demo.domain.model.User;
import com.example.demo.domain.service.UserService;
import com.example.demo.validation.OnCreate;
import com.example.demo.web.dto.UserDTO;
import com.example.demo.web.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Validated
public class UserControler {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/new")
    @Validated(OnCreate.class)

    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.save(userMapper.fromDto(userDTO));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userMapper.toDto(user));
    }


    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<UserDTO> findByEmail(@RequestParam String email) {

        return ResponseEntity.ok(userMapper.toDto(userService.findUserByEmail(email)));
    }
}
