package com.omael.gestiondestock.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CompaniesDto {
    private String name;

    private String description;

    private AddressDto address;

    private String taxCode;

    private String logo;

    private String email;

    private String phone;

    private String webSite;

    private List<UserDto> users;
}
