package com.example.demo.domain.service.impl;

import com.example.demo.domain.model.Order;
import com.example.demo.domain.model.OrderDish;
import com.example.demo.domain.repository.OrderDishReporitory;
import com.example.demo.domain.service.OrderDishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultOrderDishService implements OrderDishService {

    private final OrderDishReporitory orderDishReporitory;

    @Override
    public List<OrderDish> findAll() {
        return orderDishReporitory.findAll();
    }

    @Override
    public OrderDish save(OrderDish orderDish) {
        return orderDishReporitory.save(orderDish);
    }
}
