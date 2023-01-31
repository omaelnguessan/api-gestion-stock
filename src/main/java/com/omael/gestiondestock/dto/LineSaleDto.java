package com.omael.gestiondestock.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LineSaleDto {
    private SaleDto sale;

    private BigDecimal unitPrice;

    private BigDecimal quantity;
}
