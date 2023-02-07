package com.omael.gestiondestock.validator;

import com.omael.gestiondestock.dto.OrderCustomerDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderCustomerValidator {
    public static List<String> validate(OrderCustomerDto orderCustomerDto) {
        List<String> errors = new ArrayList<>();
         if (orderCustomerDto == null) {
             errors.add("Veuillez saisir le code");
             errors.add("Veuillez saisir la date de la commande");
             errors.add("Veuillez selectionner le client");
         } else {
             if (!StringUtils.hasLength(orderCustomerDto.getCode())) {
                 errors.add("Veuillez saisir le code");
             }

             if (orderCustomerDto.getDateOrder() == null) {
                 errors.add("Veuillez saisir la date de la commande");
             }

             if (orderCustomerDto.getCustomer() == null) {
                 errors.add("Veuillez selectionner le client");
             }
         }
        return errors;
    }
}
