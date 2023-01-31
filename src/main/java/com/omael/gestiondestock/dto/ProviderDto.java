package com.omael.gestiondestock.dto;

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
}
