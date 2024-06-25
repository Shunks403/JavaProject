package com.example.demo.web.mapper;

import com.example.demo.domain.model.OrderDish;
import com.example.demo.web.dto.OrderDishDTO;
import org.mapstruct.Mapper;



public interface OrderDishMapper {
    OrderDish fromDto(OrderDishDTO orderDishDTO);

    OrderDishDTO toDto(OrderDish orderDish);
}
