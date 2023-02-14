package com.omael.gestiondestock.dto;

import com.omael.gestiondestock.model.Roles;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RolesDto {

    private Integer id;

    private String roleName;

    private UserDto user;

    public static RolesDto fromEntity(Roles roles) {
        if (roles == null) {
            //TODO throw an exception
            return null;
        }

        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .user(UserDto.fromEntity(roles.getUser()))
                .build();
    }

    public static Roles toEntity(RolesDto rolesDto) {
        if (rolesDto == null) {
            //TODO throw an exception
            return null;
        }
        Roles roles = new Roles();
        roles.setRoleName(rolesDto.getRoleName());
        return roles;
    }
}
