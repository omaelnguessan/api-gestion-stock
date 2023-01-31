package com.omael.gestiondestock.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {

    private Integer id;

    private String codeArticle;

    private String designation;

    private BigDecimal unitPriceHt;

    private BigDecimal rateVat;

    private BigDecimal unitPriceTTC;

    private String picture;

    private CategoryDto category;

}
