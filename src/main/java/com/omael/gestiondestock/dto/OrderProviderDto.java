package com.omael.gestiondestock.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class OrderProviderDto {

    private Integer id;

    private String code;

    private Instant dateOrder;

    private ProviderDto provider;

    private List<LineOrderProviderDto> lineOrderProviders;
}
