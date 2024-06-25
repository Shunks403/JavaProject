package com.example.demo.web.mapper;

import com.example.demo.domain.model.Order;
import com.example.demo.web.dto.OrderDTO;

public interface OrderMapper {


    Order fromDto(OrderDTO OrderDTO);

    OrderDTO toDto(Order order);

}
