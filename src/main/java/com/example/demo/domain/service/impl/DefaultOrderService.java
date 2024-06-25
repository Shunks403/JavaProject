package com.example.demo.domain.service.impl;

import com.example.demo.domain.model.Order;
import com.example.demo.domain.model.OrderDish;
import com.example.demo.domain.repository.OrderRepository;
import com.example.demo.domain.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DefaultOrderService implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public Order findById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order save(Order order) {
        order.setOrderDateTime(LocalDateTime.now());
        for (OrderDish orderDish : order.getOrderDishes()) {
            orderDish.setOrder(order);
        }
        return orderRepository.save(order);

    }
}
