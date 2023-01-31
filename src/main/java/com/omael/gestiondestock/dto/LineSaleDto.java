package com.omael.gestiondestock.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LineSaleDto {

    private Integer id;

    private SaleDto sale;

    private BigDecimal unitPrice;

    private BigDecimal quantity;
}
