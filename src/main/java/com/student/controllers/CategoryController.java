package com.student.controllers;

import com.student.dtos.CategoryDto;
import com.student.services.impl.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author : Viet Van Lau
 * @project design-pattern
 * @created 03/06/2023 - 6:08 PM
 */
@RestController
@RequestMapping("/v1/category")

public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> get(@PathVariable String id) {
        return new ResponseEntity<>(categoryService.getCategory(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Page<CategoryDto>> getList(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        Page<CategoryDto> enrollmentPage = categoryService.getListCategory(pageable);
        return new ResponseEntity<>(enrollmentPage, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CategoryDto> create(@Valid @RequestBody CategoryDto dto) {
        return new ResponseEntity<>(categoryService.createCategory(dto), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable String id, @Valid @RequestBody CategoryDto dto) {
        return new ResponseEntity<>(categoryService.updateCategory(id, dto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryDto> delete(@PathVariable String id) {
        return new ResponseEntity<>(categoryService.deleteCategory(id), HttpStatus.OK);
    }
}
