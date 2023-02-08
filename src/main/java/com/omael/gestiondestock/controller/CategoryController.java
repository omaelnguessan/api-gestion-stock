package com.omael.gestiondestock.controller;

import com.omael.gestiondestock.controller.api.CategoryApi;
import com.omael.gestiondestock.dto.CategoryDto;
import com.omael.gestiondestock.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController implements CategoryApi {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return this.categoryService.save(categoryDto);
    }

    @Override
    public CategoryDto findById(Integer categoryId) {
        return this.categoryService.findById(categoryId);
    }

    @Override
    public CategoryDto findByCodeArticle(String codeCategory) {
        return this.categoryService.findByCodeArticle(codeCategory);
    }

    @Override
    public List<CategoryDto> findAll() {
        return this.categoryService.findAll();
    }

    @Override
    public void delete(Integer categoryId) {
        this.categoryService.delete(categoryId);
    }
}
