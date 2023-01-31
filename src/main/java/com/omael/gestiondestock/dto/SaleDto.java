package com.omael.gestiondestock.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class SaleDto {

    private Integer id;

    private String code;

    private Instant dateSale;

    private String remark;
}
