package com.omael.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omael.gestiondestock.model.LineOrderProvider;
import com.omael.gestiondestock.model.LineOrderProvider;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Builder
@Data
public class LineOrderProviderDto {

    private Integer id;

    private ArticleDto article;

    @JsonIgnore
    private OrderProviderDto orderProvider;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private Integer idCompanies;


    public static LineOrderProviderDto fromEntity(LineOrderProvider lineOrderProvider) {
        if (lineOrderProvider == null) {
            //TODO throw an exception
            return null;
        }

        return LineOrderProviderDto.builder()
                .id(lineOrderProvider.getId())
                .quantity(lineOrderProvider.getQuantity())
                .unitPrice(lineOrderProvider.getUnitPrice())
                .idCompanies(lineOrderProvider.getIdCompanies())
                .orderProvider(OrderProviderDto.fromEntity(lineOrderProvider.getOrderProvider()))
                .build();

    }

    public static LineOrderProvider toEntity(LineOrderProviderDto lineOrderProviderDto) {
        if (lineOrderProviderDto == null) {
            //TODO throw an exception
            return null;
        }

        LineOrderProvider lineOrderProvider = new LineOrderProvider();
        lineOrderProvider.setQuantity(lineOrderProviderDto.getQuantity());
        lineOrderProvider.setUnitPrice(lineOrderProviderDto.getUnitPrice());
        lineOrderProvider.setIdCompanies(lineOrderProviderDto.getIdCompanies());
        return lineOrderProvider;
    }
}
