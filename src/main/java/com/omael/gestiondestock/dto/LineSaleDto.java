package com.omael.gestiondestock.dto;

import com.omael.gestiondestock.model.LineSale;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LineSaleDto {

    private Integer id;

    private SaleDto sale;

    private ArticleDto article;

    private BigDecimal unitPrice;

    private BigDecimal quantity;

    private Integer idCompanies;

    public static LineSaleDto fromEntity(LineSale lineSale) {
        if (lineSale == null) {
            //TODO throw an exception
            return null;
        }

        return LineSaleDto.builder()
                .id(lineSale.getId())
                .unitPrice(lineSale.getUnitPrice())
                .quantity(lineSale.getQuantity())
                .idCompanies(lineSale.getIdCompanies())
                .sale(SaleDto.fromEntity(lineSale.getSale()))
                .article(ArticleDto.fromEntity(lineSale.getArticle()))
                .build();
    }

    public static LineSale toEntity(LineSaleDto lineSaleDto) {
        if (lineSaleDto == null) {
            //TODO throw an exception
            return null;
        }

        LineSale lineSale = new LineSale();
        lineSale.setQuantity(lineSaleDto.getQuantity());
        lineSale.setUnitPrice(lineSaleDto.getUnitPrice());
        lineSale.setIdCompanies(lineSaleDto.getIdCompanies());
        return lineSale;
    }
}
