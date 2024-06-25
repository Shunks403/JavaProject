package com.example.demo.domain.service;

import com.example.demo.domain.model.Category;
import com.example.demo.domain.model.Order;

import java.util.List;

public interface OrderService {
    public Order findById(long id);

    List<Order> findAll();

    Order save(Order order);
}
