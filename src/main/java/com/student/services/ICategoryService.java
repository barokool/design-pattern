package com.student.services;

import com.student.dtos.CategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    CategoryDto getCategory(String id);

    CategoryDto createCategory (CategoryDto dto);

    CategoryDto updateCategory (String id, CategoryDto dto);

    CategoryDto deleteCategory (String id);
    Page<CategoryDto> getListCategory(Pageable pageable);

}
