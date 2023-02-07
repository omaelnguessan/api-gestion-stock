package com.omael.gestiondestock.validator;

import com.omael.gestiondestock.dto.OrderProviderDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderProviderValidator {
    public static List<String> validate(OrderProviderDto orderProviderDto) {
        List<String> errors = new ArrayList<>();
        if (orderProviderDto == null) {
            errors.add("Veuillez saisir le code");
            errors.add("Veuillez saisir la date de la commande");
            errors.add("Veuillez selectionner le fournisseur");
        } else {
            if (!StringUtils.hasLength(orderProviderDto.getCode())) {
                errors.add("Veuillez saisir le code");
            }

            if (orderProviderDto.getDateOrder() == null) {
                errors.add("Veuillez saisir la date de la commande");
            }

            if (orderProviderDto.getProvider() == null) {
                errors.add("Veuillez selectionner le fournisseur");
            }
        }
        return errors;
    }
}
