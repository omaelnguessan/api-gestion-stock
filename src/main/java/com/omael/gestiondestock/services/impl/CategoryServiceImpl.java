package com.omael.gestiondestock.services.impl;

import com.omael.gestiondestock.dto.CategoryDto;
import com.omael.gestiondestock.exception.EntityNotFoundException;
import com.omael.gestiondestock.exception.ErrorCodes;
import com.omael.gestiondestock.exception.InvalidEntityException;
import com.omael.gestiondestock.model.Category;
import com.omael.gestiondestock.repository.CategoryRepository;
import com.omael.gestiondestock.services.CategoryService;
import com.omael.gestiondestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.validate(categoryDto);

        if (!errors.isEmpty()) {
            log.error("Category is not valid {}", categoryDto);
            throw new InvalidEntityException("Erreur lors de la validation de la category", ErrorCodes.CATEGORY_NOT_VALID);
        }

        return CategoryDto.fromEntity(
                categoryRepository.save(
                        CategoryDto.toEntity(categoryDto)
                )
        );
    }

    @Override
    public CategoryDto findById(Integer categoryId) {
        if(categoryId == null) {
            log.error("Category ID is null");
            return null;
        }

        Optional<Category> category = categoryRepository.findById(categoryId);

        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(() -> new EntityNotFoundException("Error category with ID "+categoryId+" not found", ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public CategoryDto findByCodeArticle(String codeCategory) {
        if (!StringUtils.hasLength(codeCategory)) {
            log.error("Category CODE is null");
            return null;
        }

        Optional<Category> category = categoryRepository.findCategoriesByCodeCategory(codeCategory);

        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(() -> new EntityNotFoundException("Error category with CODE "+codeCategory+" not found", ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer categoryId) {
        if (categoryId == null) {
            log.error("Category ID is null");
            return;
        }

        categoryRepository.deleteById(categoryId);
    }
}
