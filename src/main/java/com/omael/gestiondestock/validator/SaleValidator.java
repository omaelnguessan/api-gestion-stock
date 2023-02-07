package com.omael.gestiondestock.validator;

import com.omael.gestiondestock.dto.SaleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SaleValidator {
    public static List<String> validate(SaleDto saleDto) {
        List<String> errors = new ArrayList<>();

        if (saleDto ==  null) {
            errors.add("Veuillez saisir le code");
            errors.add("Veuillez saisir l'observation");
            errors.add("Veuillez saisir la date de vente");
        }
        else {
            if(!StringUtils.hasLength(saleDto.getCode())) {
                errors.add("Veuillez saisir le code");
            }

            if(!StringUtils.hasLength(saleDto.getRemark())) {
                errors.add("Veuillez saisir l'observation");
            }

            if(saleDto.getDateSale() == null) {
                errors.add("Veuillez saisir la date de vente");
            }
        }
        return errors;
    }
}
