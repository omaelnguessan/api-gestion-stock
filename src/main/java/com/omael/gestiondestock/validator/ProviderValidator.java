package com.omael.gestiondestock.validator;


import com.omael.gestiondestock.dto.ProviderDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ProviderValidator {
    public static List<String> validate(ProviderDto providerDto) {
        List<String> errors = new ArrayList<>();

        if (providerDto == null) {
            errors.add("Veuillez rensigner le nom du fournisseur");
            errors.add("Veuillez rensigner le prénom du fournisseur");
            errors.add("Veuillez rensigner le email du fournisseur");
            errors.add("Veuillez rensigner le contact du fournisseur");
        } else {
            if (!StringUtils.hasLength(providerDto.getFirstName())) {
                errors.add("Veuillez rensigner le nom du fournisseur");
            }

            if (!StringUtils.hasLength(providerDto.getFirstName())) {
                errors.add("Veuillez rensigner le prénom du fournisseur");
            }

            if (!StringUtils.hasLength(providerDto.getEmail())) {
                errors.add("Veuillez rensigner le email du fournisseur");
            }

            if (!StringUtils.hasLength(providerDto.getPhone())) {
                errors.add("Veuillez rensigner le contact du fournisseur");
            }
        }

        return errors;
    }
}
