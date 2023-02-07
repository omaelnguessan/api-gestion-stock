package com.omael.gestiondestock.validator;

import com.omael.gestiondestock.dto.CompaniesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CompagniesValidator {
    public static List<String> validator(CompaniesDto companiesDto) {
        List<String> errors = new ArrayList<>();

        if (companiesDto == null) {
            errors.add("Veuillez saisir le nom de la compagnie");
            errors.add("Veuillez saisir l'email de la compagnie");
            errors.add("Veuillez saisir le contact de la compagnie");
            errors.add("Veuillez saisir la description de la compagnie");
            errors.add("Veuillez renseigner l'adresse");
            errors.add("Veuillez saisir le code tax de la compagnie");
        } else {
            if (!StringUtils.hasLength(companiesDto.getName())) {
                errors.add("Veuillez saisir le nom de la compagnie");
            }

            if (!StringUtils.hasLength(companiesDto.getEmail())) {
                errors.add("Veuillez saisir l'email de la compagnie");
            }

            if (!StringUtils.hasLength(companiesDto.getPhone())) {
                errors.add("Veuillez saisir le contact de la compagnie");
            }

            if (!StringUtils.hasLength(companiesDto.getDescription())) {
                errors.add("Veuillez saisir la description de la compagnie");
            }

            if(companiesDto.getAddress() == null) {
                errors.add("Veuillez renseigner l'adresse");
            } else {
                if(companiesDto.getAddress().getAddress1() == null) {
                    errors.add("Veuillez renseigner l'adresse");
                }
                if(companiesDto.getAddress().getCountry() == null) {
                    errors.add("Veuillez renseigner le pays");
                }
                if(companiesDto.getAddress().getZipCode() == null) {
                    errors.add("Veuillez renseigner le code postal");
                }
                if(companiesDto.getAddress().getCity() == null) {
                    errors.add("Veuillez renseigner la ville");
                }
            }

            if (companiesDto.getTaxCode() == null) {
                errors.add("Veuillez saisir le code tax de la compagnie");
            }
        }

        return errors;
    }
}
