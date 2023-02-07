package com.omael.gestiondestock.dto;

import com.omael.gestiondestock.model.Article;
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

    public static ArticleDto fromEntity (Article article) {
        if (article == null) {
            //TODO throw an exception
            return null;
        }

        return ArticleDto.builder()
                .id(article.getId())
                .designation(article.getDesignation())
                .codeArticle(article.getCodeArticle())
                .unitPriceHt(article.getUnitPriceHt())
                .unitPriceTTC(article.getUnitPriceTTC())
                .rateVat(article.getRateVat())
                .picture(article.getPicture())
                .build();
    }


    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            //TODO throw an exception
            return null;
        }

        Article article = new Article();
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setUnitPriceHt(articleDto.getUnitPriceHt());
        article.setUnitPriceTTC(articleDto.getUnitPriceTTC());
        article.setRateVat(articleDto.getRateVat());
        article.setPicture(articleDto.getPicture());
        return article;
    }

}
