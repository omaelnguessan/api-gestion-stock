package com.omael.gestiondestock.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {
    private String address1;

    private String address2;

    private String city;

    private String zipCode;

    private String country;
}
