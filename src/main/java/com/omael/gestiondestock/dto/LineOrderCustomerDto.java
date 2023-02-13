package com.omael.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omael.gestiondestock.model.LineOrderCustomer;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LineOrderCustomerDto {

    private Integer id;

    private ArticleDto article;

    @JsonIgnore
    private OrderCustomerDto orderCustomer;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private Integer idCompanies;

    public static LineOrderCustomerDto fromEntity(LineOrderCustomer lineOrderCustomer) {
        if (lineOrderCustomer == null) {
            //TODO throw an exception
            return null;
        }

        return LineOrderCustomerDto.builder()
                .id(lineOrderCustomer.getId())
                .quantity(lineOrderCustomer.getQuantity())
                .unitPrice(lineOrderCustomer.getUnitPrice())
                .idCompanies(lineOrderCustomer.getIdCompanies())
                .build();
    }

    public static LineOrderCustomer toEntity(LineOrderCustomerDto lineOrderCustomerDto) {
        if (lineOrderCustomerDto == null) {
            //TODO throw an exception
            return null;
        }

        LineOrderCustomer lineOrderCustomer = new LineOrderCustomer();
        lineOrderCustomer.setQuantity(lineOrderCustomerDto.getQuantity());
        lineOrderCustomer.setUnitPrice(lineOrderCustomerDto.getUnitPrice());
        lineOrderCustomer.setIdCompanies(lineOrderCustomerDto.getIdCompanies());
        return lineOrderCustomer;
    }
}
