package com.example.demo.domain.service;

import com.example.demo.domain.model.Category;
import com.example.demo.domain.model.Dish;

import java.util.List;

public interface DishService {
    Dish findByDishName(String dishName);

    Dish save(Dish Dish);

    List<Dish> findAll();

    Dish findById(int id);
}
