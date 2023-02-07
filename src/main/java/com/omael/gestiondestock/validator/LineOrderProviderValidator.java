package com.omael.gestiondestock.validator;

import com.omael.gestiondestock.dto.LineOrderProviderDto;

import java.util.ArrayList;
import java.util.List;

public class LineOrderProviderValidator {

    public static List<String> validate(LineOrderProviderDto lineOrderProviderDto) {
        List<String> errors = new ArrayList<>();

        if (lineOrderProviderDto == null) {
            errors.add("Veuillez selectionner le fournisseur");
            errors.add("Veuillez selectionner l'article");
            errors.add("Veuillez saisir le prix unitaire l'article");
            errors.add("Veuillez saisir une quantité l'article");

        } else {
            if(lineOrderProviderDto.getOrderProvider() == null) {
                errors.add("Veuillez selectionner le fournisseur");
            }

            if(lineOrderProviderDto.getArticle() == null) {
                errors.add("Veuillez selectionner l'article");
            }

            if(lineOrderProviderDto.getUnitPrice() == null) {
                errors.add("Veuillez saisir le prix unitaire l'article");
            }

            if(lineOrderProviderDto.getQuantity() == null) {
                errors.add("Veuillez saisir une quantité l'article");
            }
        }
        return errors;
    }
}
