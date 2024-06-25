package com.example.demo.web.mapper;

import com.example.demo.domain.model.User;
import com.example.demo.web.dto.UserDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromDto(UserDTO userDTO);

    UserDTO toDto(User user);

}
