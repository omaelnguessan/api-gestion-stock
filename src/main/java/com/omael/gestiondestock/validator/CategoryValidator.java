package com.omael.gestiondestock.validator;

import com.omael.gestiondestock.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {
    public static List<String> validate (CategoryDto categoryDto) {
        List<String> errors = new ArrayList<>();
        if(categoryDto == null || !StringUtils.hasLength(categoryDto.getCodeCategory())) {
            errors.add("Veuillez renseigner le code de la catégorie");
        }
        return errors;
    }

}
