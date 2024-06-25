package com.example.demo.domain.service;

import com.example.demo.domain.model.Category;

import java.util.List;

public interface CategoryService {
    Category findByCategoryName(String categoryName);

    Category save(Category category);

    List<Category> findAll();
}
