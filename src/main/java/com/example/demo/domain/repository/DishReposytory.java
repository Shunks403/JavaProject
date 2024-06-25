package com.example.demo.domain.repository;

import com.example.demo.domain.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishReposytory extends JpaRepository<Dish, Long> {
    public List<Dish> findAll();

    public Dish findByDishName(String dishName);

    public Dish findByDishId(int dishId);
}
