package com.example.demo.domain.service.impl;

import com.example.demo.web.config.MyUserDetails;
import com.example.demo.domain.repository.UserRepository;
import com.example.demo.web.dto.UserDTO;
import com.example.demo.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultUserDatailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDTO> userDTO = Optional.ofNullable(userMapper.toDto(userRepository.findByUsername(username)));
        return userDTO.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
