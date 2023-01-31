package com.omael.gestiondestock.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LineOrderCustomerDto {

    private Integer id;

    private ArticleDto article;

    private OrderCustomerDto orderCustomer;

    private BigDecimal quantity;

    private BigDecimal unitPrice;
}
