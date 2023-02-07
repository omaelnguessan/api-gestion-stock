package com.omael.gestiondestock.validator;

import com.omael.gestiondestock.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public static List<String> validate(ArticleDto articleDto) {
        List<String> errors =  new ArrayList<>();

        if (articleDto == null) {
            errors.add("Veuillez renseigner le code de l'article");
            errors.add("Veuillez renseigner le prix ht de l'article");
            errors.add("Veuillez renseigner le prix ttc de l'article");
            errors.add("Veuillez renseigner le taux de la tva de l'article");
            errors.add("Veuillez renseigner la désignation de l'article");
            errors.add("Veuillez selectionner une catégorie");
        } else {
            if (!StringUtils.hasLength(articleDto.getCodeArticle())) {
                errors.add("Veuillez renseigner le code de l'article");
            }

            if (articleDto.getUnitPriceHt() == null) {
                errors.add("Veuillez renseigner le prix ht de l'article");
            }

            if (articleDto.getUnitPriceTTC() == null) {
                errors.add("Veuillez renseigner le prix ttc de l'article");
            }

            if (articleDto.getRateVat() == null) {
                errors.add("Veuillez renseigner le taux de la tva de l'article");
            }

            if (!StringUtils.hasLength(articleDto.getDesignation())) {
                errors.add("Veuillez renseigner la désignation de l'article");
            }

            if(articleDto.getCategory() == null) {
                errors.add("Veuillez selectionner une catégorie");
            }
        }

        return errors;
    }
}
