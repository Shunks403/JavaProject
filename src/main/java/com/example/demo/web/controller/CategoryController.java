package com.example.demo.web.controller;

import com.example.demo.domain.model.Category;
import com.example.demo.domain.service.CategoryService;
import com.example.demo.web.dto.CategoryDTO;
import com.example.demo.web.mapper.CategoryMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;
    @PostMapping("/add")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        Category category = categoryService.save(categoryMapper.fromDto(categoryDTO));
        return ResponseEntity.ok(categoryMapper.toDto(category));
    }
    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAll(){
        List<CategoryDTO> CategoryesDTO = new ArrayList<>();
        for(Category category : categoryService.findAll()){
            CategoryesDTO.add(categoryMapper.toDto(category));
        }
        return ResponseEntity.ok(CategoryesDTO);
    }

}
