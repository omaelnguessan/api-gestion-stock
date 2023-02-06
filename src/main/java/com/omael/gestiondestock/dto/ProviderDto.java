package com.omael.gestiondestock.dto;

import com.omael.gestiondestock.model.Provider;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ProviderDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private AddressDto address;

    private String picture;

    private String email;

    private String phone;

    private List<OrderProviderDto> orderProviders;

    public static ProviderDto fromEntity(Provider provider) {
        if (provider == null) {
            //TODO throw an exception
            return null;
        }

        return ProviderDto.builder()
                .id(provider.getId())
                .firstName(provider.getFirstName())
                .lastName(provider.getLastName())
                .picture(provider.getPicture())
                .email(provider.getEmail())
                .phone(provider.getPhone())
                .build();
    }

    public static Provider toEntity(ProviderDto providerDto) {
        if (providerDto == null) {
            //TODO throw an exception
            return null;
        }

        Provider provider = new Provider();
        provider.setFirstName(providerDto.getFirstName());
        provider.setLastName(providerDto.getLastName());
        provider.setEmail(providerDto.getEmail());
        provider.setPhone(providerDto.getPhone());
        provider.setPicture(providerDto.getPicture());
        return provider;
    }
}
