package com.example.demo.domain.service;

import com.example.demo.domain.model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

public interface UserService {

    User findUserByEmail(String email);
    User findUserById(Long id);
    User save(User user);
    UserDetails findByUsername(String username);




}
