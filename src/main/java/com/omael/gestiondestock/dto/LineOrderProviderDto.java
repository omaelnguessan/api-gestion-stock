package com.omael.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omael.gestiondestock.model.LineOrderCustomer;
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


    public static LineOrderProviderDto fromEntity(LineOrderCustomer lineOrderCustomer) {
        if (lineOrderCustomer == null) {
            //TODO throw an exception
            return null;
        }

        return LineOrderProviderDto.builder()
                .id(lineOrderCustomer.getId())
                .quantity(lineOrderCustomer.getQuantity())
                .unitPrice(lineOrderCustomer.getUnitPrice())
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
        return lineOrderProvider;
    }
}
