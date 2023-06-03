package com.student.factories.impl;

import com.student.dtos.CategoryDto;
import com.student.entities.Category;
import com.student.entities.Task;
import com.student.factories.CreateEntity;

/**
 * @author : Viet Van Lau
 * @project design-pattern
 * @created 03/06/2023 - 5:33 PM
 */
public class CategoryImlp implements CreateEntity<Category, CategoryDto> {
    @Override
    public Category create(CategoryDto dto) {
        return new Category(dto.getName());
    }
}
