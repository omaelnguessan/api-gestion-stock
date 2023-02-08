package com.omael.gestiondestock.repository;

import com.omael.gestiondestock.dto.CategoryDto;
import com.omael.gestiondestock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findCategoriesByCodeCategory(String codeCategory);
}
