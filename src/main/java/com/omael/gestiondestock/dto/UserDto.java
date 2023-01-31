package com.omael.gestiondestock.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class UserDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private AddressDto address;

    private String picture;

    private Instant dateBirth;

    private String email;

    private String password;

    private CompaniesDto companies;

    private List<RolesDto> roles;
}
