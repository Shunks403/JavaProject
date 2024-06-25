package com.example.demo.domain.repository;

import com.example.demo.domain.model.Dish;
import com.example.demo.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Long> {
    public List<Order> findAll();

    public Order findById(long id);


    public Order save(Order order);

}
