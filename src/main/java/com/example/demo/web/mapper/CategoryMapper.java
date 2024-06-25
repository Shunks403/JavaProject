package com.example.demo.web.mapper;

import com.example.demo.domain.model.Category;
import com.example.demo.web.dto.CategoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category fromDto(CategoryDTO CategoryDTO);

    CategoryDTO toDto(Category Category);
}
