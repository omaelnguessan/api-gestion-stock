package com.omael.gestiondestock.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Builder
@Data
public class LineOrderProviderDto {

    private Integer id;

    private ArticleDto article;

    private OrderProviderDto orderProvider;

    private BigDecimal quantity;

    private BigDecimal unitPrice;
}
