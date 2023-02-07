package com.omael.gestiondestock.validator;

import com.omael.gestiondestock.dto.MvtStkDto;

import java.util.ArrayList;
import java.util.List;

public class MvtStkValidator {
    public static List<String> validate(MvtStkDto mvtStkDto) {
        List<String> errors = new ArrayList<>();

        if (mvtStkDto == null) {
            errors.add("");
        } else {
            if (mvtStkDto.getDateMvt() == null) {
                errors.add("Veuillez saisir la date de l'opération");
            }

            if (mvtStkDto.getArticle() == null) {
                errors.add("Veuillez sélection l'article");
            }

            if (mvtStkDto.getQuantity() == null) {
                errors.add("Veuillez saisir la quantité");
            }

            if (mvtStkDto.getTypeMvt() == null) {
                errors.add("Veuillez sélectionner le type d'opération");
            }
        }
        return errors;
    }
}
