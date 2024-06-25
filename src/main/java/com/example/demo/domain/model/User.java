package com.example.demo.domain.model;

import jakarta.persistence.*;

import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    private String username;
    private String password;
    private String email;
    @Column(name = "phonenumber")
    private String phoneNumber;
    private LocalDateTime createdat;
    private String role;
}
