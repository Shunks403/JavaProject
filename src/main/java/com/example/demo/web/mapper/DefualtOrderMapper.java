package com.example.demo.web.mapper;

import com.example.demo.domain.model.Order;
import com.example.demo.domain.model.OrderDish;
import com.example.demo.domain.repository.OurTableRespository;
import com.example.demo.domain.repository.UserRepository;
import com.example.demo.domain.service.OurTableService;
import com.example.demo.domain.service.UserService;
import com.example.demo.web.dto.OrderDTO;
import com.example.demo.web.dto.OrderDishDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("DefualtOrderMapper")
@AllArgsConstructor
public class DefualtOrderMapper implements OrderMapper {

    @Autowired
    private final UserService userService;
    private final OurTableService ourTableService;
    private final DefualtOrderDishMapper OrderDishMapper;


    @Override
    public Order fromDto(OrderDTO OrderDTO) {
        Order order = new Order();

        order.setUser(userService.findUserById(OrderDTO.getUserId()));
        order.setOurTable(ourTableService.findById(OrderDTO.getTableId()));
        order.setTotalAmount(OrderDTO.getTotalAmount());

        List<OrderDish> orderDishes = new ArrayList<>();

        for (OrderDishDTO orderDishDTO : OrderDTO.getOrderDishes()) {
            orderDishes.add(OrderDishMapper.fromDto(orderDishDTO));
        }

        order.setOrderDishes(orderDishes);
        return order;
    }

    @Override
    public OrderDTO toDto(Order order) {

        OrderDTO OrderDTO = new OrderDTO();

        OrderDTO.setUserId(order.getUser().getUserid());
        OrderDTO.setTableId(order.getOurTable().getTableID());
        OrderDTO.setTotalAmount(order.getTotalAmount());
        OrderDTO.setOrderDateTime(order.getOrderDateTime());

        List<OrderDishDTO> orderDishes = new ArrayList<>();

        for (OrderDish orderDish : order.getOrderDishes()) {
            orderDishes.add(OrderDishMapper.toDto(orderDish));
        }
        OrderDTO.setOrderDishes(orderDishes);

        OrderDTO.setOrderId(order.getOrderId());

        return OrderDTO;
    }
}
