package com.omael.gestiondestock.dto;


import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class UserDto {

    private String firstName;

    private String lastName;

    private AddressDto address;

    private String picture;

    private Instant dateBirth;

    private String email;

    private String password;
}
