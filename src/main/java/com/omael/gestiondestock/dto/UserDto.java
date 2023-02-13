package com.omael.gestiondestock.dto;

import com.omael.gestiondestock.model.User;
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

    public static UserDto fromEntity(User user) {
        if (user == null) {
            //TODO throw an exception
            return null;
        }

        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .dateBirth(user.getDateBirth())
                .email(user.getEmail())
                .password(user.getPassword())
                .picture(user.getPicture())
                .companies(CompaniesDto.fromEntity(user.getCompanies()))
                .build();
    }

    public static User toEntity(UserDto userDto) {
        if (userDto == null) {
            //TODO throw an exception
            return null;
        }

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setDateBirth(userDto.getDateBirth());
        user.setPicture(userDto.getPicture());
        user.setCompanies(CompaniesDto.toEntity(userDto.getCompanies()) );
        return user;
    }
}
