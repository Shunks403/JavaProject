package com.example.demo.domain.repository;

import com.example.demo.domain.model.Dish;
import com.example.demo.domain.model.OrderDish;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderDishReporitory extends JpaRepository<OrderDish, Long> {

    public List<OrderDish> findAll();

}
