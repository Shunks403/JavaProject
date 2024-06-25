package com.example.demo.web.dto;



import com.example.demo.validation.OnCreate;
import com.example.demo.validation.OnUpdate;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.context.annotation.Role;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {

    @Null(groups = {OnCreate.class}, message = "User ID must be null when creating a new user")
    private Integer userId;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Username cannot be blank")
    @Size(min = 2, message = "Username must be at least 2 characters long", groups = {OnCreate.class, OnUpdate.class})
    private String username;

    @NotBlank(groups = {OnCreate.class}, message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 6 characters long", groups = {OnCreate.class})
    private String password;

    @Email(groups = {OnCreate.class, OnUpdate.class}, message = "Email is not valid")
    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Email cannot be blank")
    private String email;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Phone number cannot be blank")
    @Pattern(regexp = "\\+?[0-9. ()-]{7,25}", message = "Phone number is not valid", groups = {OnCreate.class, OnUpdate.class})
    private String phoneNumber;

    @Null(groups = {OnCreate.class}, message = "Created date must be null when creating a new user")
    private LocalDateTime createdAt;


    private String role;

}
