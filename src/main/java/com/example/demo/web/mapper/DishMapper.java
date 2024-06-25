package com.example.demo.web.mapper;

import com.example.demo.domain.model.Dish;
import com.example.demo.web.dto.DishDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DishMapper {

    Dish fromDto(DishDTO dishDTO);

    DishDTO toDto(Dish dish);
}
