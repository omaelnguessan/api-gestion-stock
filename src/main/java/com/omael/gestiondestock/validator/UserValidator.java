package com.omael.gestiondestock.validator;

import com.omael.gestiondestock.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {
    public static List<String> validate(UserDto userDto) {
        List<String> errors = new ArrayList<>();

        if(userDto == null) {
            errors.add("Veuillez renseigner le nom");
            errors.add("Veuillez renseigner le prénom");
            errors.add("Veuillez renseigner l'adresse'");
            errors.add("Veuillez renseigner l'email");
            errors.add("Veuillez renseigner le mot de passe");
            errors.add("Veuillez renseigner la date de naissance");
        } else {
            if(!StringUtils.hasLength(userDto.getFirstName())) {
                errors.add("Veuillez renseigner le nom");
            }

            if(!StringUtils.hasLength(userDto.getLastName())) {
                errors.add("Veuillez renseigner le prénom");
            }

            if(userDto.getAddress() == null) {
                errors.add("Veuillez renseigner l'adresse'");
            } else {
                if(userDto.getAddress().getAddress1() == null) {
                    errors.add("Veuillez renseigner l'adresse");
                }
                if(userDto.getAddress().getCountry() == null) {
                    errors.add("Veuillez renseigner le pays");
                }
                if(userDto.getAddress().getZipCode() == null) {
                    errors.add("Veuillez renseigner le code postal");
                }
                if(userDto.getAddress().getCity() == null) {
                    errors.add("Veuillez renseigner la ville");
                }
            }

            if(!StringUtils.hasLength(userDto.getEmail())) {
                errors.add("Veuillez renseigner l'email");
            }

            if(!StringUtils.hasLength(userDto.getPassword())) {
                errors.add("Veuillez renseigner le mot de passe");
            }

            if(!StringUtils.hasLength(userDto.getPassword())) {
                errors.add("Veuillez renseigner le mot de passe");
            }

            if(userDto.getDateBirth() == null) {
                errors.add("Veuillez renseigner la date de naissance");
            }

        }


        return errors;
    }
}
