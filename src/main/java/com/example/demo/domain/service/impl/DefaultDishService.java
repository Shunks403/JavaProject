package com.example.demo.domain.service.impl;

import com.example.demo.domain.model.Dish;
import com.example.demo.domain.repository.DishReposytory;
import com.example.demo.domain.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultDishService implements DishService {
private final DishReposytory dishReposytory;

    @Override
    public Dish findByDishName(String dishName) {
        return  dishReposytory.findByDishName(dishName);
    }

    @Override
    public Dish save(Dish Dish) {
        return dishReposytory.save(Dish);
    }

    @Override
    public List<Dish> findAll() {
        return dishReposytory.findAll();
    }

    @Override
    public Dish findById(int id) {
        return dishReposytory.findByDishId(id);
    }


}
