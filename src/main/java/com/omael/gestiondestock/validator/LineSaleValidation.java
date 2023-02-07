package com.omael.gestiondestock.validator;

import com.omael.gestiondestock.dto.LineSaleDto;

import java.util.ArrayList;
import java.util.List;

public class LineSaleValidation {
    public static List<String> validate(LineSaleDto lineSaleDto) {
        List<String> errors = new ArrayList<>();

        if (lineSaleDto == null) {
            errors.add("Veuillez saisir la quantité");
            errors.add("Veuillez saisir le prix unitaire");
            errors.add("Veuillez sélectionner l'opération de vente");
        } else {
            if (lineSaleDto.getQuantity() == null) {
                errors.add("Veuillez saisir la quantité");
            }

            if (lineSaleDto.getUnitPrice() == null) {
                errors.add("Veuillez saisir le prix unitaire");
            }

            if (lineSaleDto.getSale() == null) {
                errors.add("Veuillez sélectionner l'opération de vente");
            }
        }

        return errors;
    }
}
