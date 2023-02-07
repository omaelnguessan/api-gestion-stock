package com.omael.gestiondestock.validator;

import com.omael.gestiondestock.dto.LineOrderCustomerDto;

import java.util.ArrayList;
import java.util.List;

public class LineOrderCustomerValidator {
    public static List<String> validator(LineOrderCustomerDto lineOrderCustomerDto) {
        List<String> errors = new ArrayList<>();

        if (lineOrderCustomerDto == null) {
            errors.add("Veuillez selectionner le client");
            errors.add("Veuillez selectionner l'article");
            errors.add("Veuillez saisir le prix unitaire l'article");
            errors.add("Veuillez saisir une quantité l'article");

        } else {
            if(lineOrderCustomerDto.getOrderCustomer() == null) {
                errors.add("Veuillez selectionner le client");
            }

            if(lineOrderCustomerDto.getArticle() == null) {
                errors.add("Veuillez selectionner l'article");
            }

            if(lineOrderCustomerDto.getUnitPrice() == null) {
                errors.add("Veuillez saisir le prix unitaire l'article");
            }

            if(lineOrderCustomerDto.getQuantity() == null) {
                errors.add("Veuillez saisir une quantité l'article");
            }
        }

        return errors;
    }
}
