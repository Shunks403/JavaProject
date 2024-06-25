package com.example.demo.web.mapper;

import com.example.demo.domain.model.OrderDish;
import com.example.demo.domain.service.DishService;
import com.example.demo.web.dto.OrderDishDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component()
@AllArgsConstructor
public class DefualtOrderDishMapper implements OrderDishMapper
{
    @Autowired
    private final DishService dishService;

    @Override
    public OrderDish fromDto(OrderDishDTO orderDishDTO) {
        OrderDish orderDish = new OrderDish();
        orderDish.setDish(dishService.findById(orderDishDTO.getDishId()));
        orderDish.setQuantity(orderDishDTO.getQuantity());

        return orderDish;
    }

    @Override
    public OrderDishDTO toDto(OrderDish orderDish) {
        OrderDishDTO orderDishDTO = new OrderDishDTO();
        orderDishDTO.setOrderDishId(orderDish.getOrderDishId());
        orderDishDTO.setDishId(orderDish.getDish().getDishId());
        orderDishDTO.setQuantity(orderDish.getQuantity());
        orderDishDTO.setOrderId(orderDish.getOrder().getOrderId());

        return orderDishDTO;
    }
}
