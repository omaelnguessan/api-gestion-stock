package com.omael.gestiondestock.dto;

import com.omael.gestiondestock.model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {

    private Integer id;

    private String codeCategory;

    private String designation;

    private List<ArticleDto> articles;

    public CategoryDto fromEntity(Category category) {
        if (category == null) {
            //TODO throw an exception
            return null;
        }

        return CategoryDto.builder().id(category.getId())
                .codeCategory(category.getCodeCategory())
                .designation(category.getDesignation())
                .build();
    }

    public Category toEntity(CategoryDto categoryDto) {
        if (categoryDto == null) {
            //TODO throw an exception
            return null;
        }
        return Category.builder()
                .codeCategory(categoryDto.codeCategory)
                .designation(categoryDto.designation)
                .build();
    }
}
