package com.omael.gestiondestock.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class OrderCustomerDto {

    private ArticleDto article;

    private OrderCustomerDto orderCustomer;

    private BigDecimal quantity;

    private BigDecimal unitPrice;
}
