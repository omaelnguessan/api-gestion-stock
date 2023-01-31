package com.omael.gestiondestock.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RolesDto {
    private String roleName;

    private UserDto user;
}
