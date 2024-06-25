package com.example.demo.domain.service;

import com.example.demo.domain.model.Order;
import com.example.demo.domain.model.OrderDish;

import java.util.List;

public interface OrderDishService {


    List<OrderDish> findAll();

    OrderDish save(OrderDish orderDish);
}
