package com.omael.gestiondestock.services;

import com.omael.gestiondestock.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto findById(Integer categoryId);

    CategoryDto findByCodeArticle(String codeCategory);

    List<CategoryDto> findAll();

    void delete(Integer categoryId);
}
