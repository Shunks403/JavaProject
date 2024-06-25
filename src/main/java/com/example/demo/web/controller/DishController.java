package com.example.demo.web.controller;

import com.example.demo.domain.model.Dish;
import com.example.demo.domain.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dishes")

public class DishController {
private final DishService dishService;

    @PostMapping

    public Dish addDish(@RequestBody Dish dish) {
        return dishService.save(dish);
    }


    @GetMapping("/all")
    public List<Dish> getAllDishes() {
        return dishService.findAll();
    }

    @GetMapping("/{name}")
    public Dish getDish(@PathVariable String name) {
        return dishService.findByDishName(name);
    }


}
