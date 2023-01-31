package com.omael.gestiondestock.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {
    private String codeCategory;

    private String designation;

    private List<ArticleDto> articles;
}
