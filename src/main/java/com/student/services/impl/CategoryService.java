package com.student.services.impl;

import com.student.dtos.CategoryDto;
import com.student.entities.Category;
import com.student.exceptions.NotFoundException;
import com.student.repositories.CategoryRepository;
import com.student.services.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {
    private final CategoryRepository CategoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    public CategoryService(CategoryRepository CategoryRepository) {
        this.CategoryRepository = CategoryRepository;
    }


    private Category setCategory(CategoryDto dto, Category Category) {
        Category.setName(dto.getName());

        CategoryRepository.save(Category);
        return Category;
    }

    public Category getCategoryById(String id) {
        return CategoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("không tồn tại", id)));
    }

    public List<CategoryDto> getAllCategory() {
        return new ArrayList<>(CategoryRepository.findAll().stream().map((element) -> modelMapper.map(element, CategoryDto.class)).collect(Collectors.toList()));
    }

    @Override
    public CategoryDto getCategory(String id) {
        Category Category = getCategoryById(id);
        return modelMapper.map(Category, CategoryDto.class);
    }

    @Override
    public CategoryDto createCategory(CategoryDto dto) {
        Category Category = new Category();
        setCategory(dto, Category);
        return modelMapper.map(Category, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(String id, CategoryDto dto) {
        Category course = getCategoryById(id);
        setCategory(dto, course);
        return modelMapper.map(course, CategoryDto.class);

    }

    @Override
    public CategoryDto deleteCategory(String id) {
        Category Category = getCategoryById(id);
        CategoryRepository.delete(Category);
        return modelMapper.map(Category, CategoryDto.class);
    }

    @Override
    public Page<CategoryDto> getListCategory(Pageable pageable) {
        return CategoryRepository.findAll(pageable).map(Category -> modelMapper.map(Category, CategoryDto.class));

    }
}
