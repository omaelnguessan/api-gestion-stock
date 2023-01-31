package com.omael.gestiondestock.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerDto {

    private String firstName;

    private String lastName;

    private AddressDto address;

    private String picture;

    private String email;

    private String phone;

    private List<OrderCustomerDto> orderCustomers;
}
