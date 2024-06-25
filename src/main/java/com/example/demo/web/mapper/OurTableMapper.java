package com.example.demo.web.mapper;

import com.example.demo.domain.model.OurTable;
import com.example.demo.domain.model.User;
import com.example.demo.web.dto.OurTableDTO;
import com.example.demo.web.dto.UserDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface OurTableMapper {
    OurTable fromDto(OurTableDTO OurTableDTO);

    OurTableDTO toDto(OurTable OurTable);
}
