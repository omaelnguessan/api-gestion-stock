package com.omael.gestiondestock.dto;

import com.omael.gestiondestock.model.LineOrderCustomer;
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

    public static LineOrderCustomerDto fromEntity(LineOrderCustomer lineOrderCustomer) {
        if (lineOrderCustomer == null) {
            //TODO throw an exception
            return null;
        }

        return LineOrderCustomerDto.builder()
                .id(lineOrderCustomer.getId())
                .quantity(lineOrderCustomer.getQuantity())
                .unitPrice(lineOrderCustomer.getUnitPrice())
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
        return lineOrderCustomer;
    }
}
