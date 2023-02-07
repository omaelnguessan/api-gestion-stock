package com.omael.gestiondestock.validator;

import com.omael.gestiondestock.dto.CustomerDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomerValidator {

    public static List<String> validate(CustomerDto customerDto) {
        List<String> errors = new ArrayList<>();

        if (customerDto == null) {
            errors.add("Veuillez rensigner le nom du client");
            errors.add("Veuillez rensigner le prénom du client");
            errors.add("Veuillez rensigner le email du client");
            errors.add("Veuillez rensigner le contact du client");
        } else {
            if (!StringUtils.hasLength(customerDto.getFirstName())) {
                errors.add("Veuillez rensigner le nom du client");
            }

            if (!StringUtils.hasLength(customerDto.getFirstName())) {
                errors.add("Veuillez rensigner le prénom du client");
            }

            if (!StringUtils.hasLength(customerDto.getEmail())) {
                errors.add("Veuillez rensigner le email du client");
            }

            if (!StringUtils.hasLength(customerDto.getPhone())) {
                errors.add("Veuillez rensigner le contact du client");
            }
        }

        return errors;
    }
}
