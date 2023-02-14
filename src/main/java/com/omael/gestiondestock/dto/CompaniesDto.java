package com.omael.gestiondestock.dto;

import com.omael.gestiondestock.model.Companies;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CompaniesDto {

    private Integer id;

    private String name;

    private String description;

    private AddressDto address;

    private String taxCode;

    private String logo;

    private String email;

    private String phone;

    private String webSite;

    private List<UserDto> users;

    public static CompaniesDto fromEntity(Companies companies) {
        if (companies == null) {
            //TODO throw an exception
            return null;
        }

        return  CompaniesDto.builder()
                .id(companies.getId())
                .name(companies.getName())
                .description(companies.getDescription())
                .logo(companies.getLogo())
                .phone(companies.getPhone())
                .email(companies.getEmail())
                .taxCode(companies.getTaxCode())
                .webSite(companies.getWebSite())
                .address(AddressDto.fromEntity(companies.getAddress()))
                .build();
    }

    public static Companies toEntity(CompaniesDto companiesDto) {
        if (companiesDto == null) {
            //TODO throw an exception
            return null;
        }

        Companies companies = new Companies();
        companies.setName(companiesDto.getName());
        companies.setDescription(companiesDto.getDescription());
        companies.setEmail(companiesDto.getEmail());
        companies.setLogo(companiesDto.getLogo());
        companies.setPhone(companiesDto.getPhone());
        companies.setTaxCode(companiesDto.getTaxCode());
        companies.setWebSite(companiesDto.getWebSite());
        return companies;
    }
}
