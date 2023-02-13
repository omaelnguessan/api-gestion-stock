package com.omael.gestiondestock.dto;

import com.omael.gestiondestock.model.Customer;
import com.omael.gestiondestock.model.OrderCustomer;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class OrderCustomerDto {
    private Integer id;

    private String code;

    private Instant dateOrder;

    private Customer customer;

    private Integer idCompanies;

    private List<LineOrderCustomerDto> lineOrderCustomers;

    public static OrderCustomerDto fromEntity(OrderCustomer orderCustomer) {
        if (orderCustomer == null) {
            //TODO throw an exception
            return null;
        }

        return OrderCustomerDto.builder()
                .id(orderCustomer.getId())
                .code(orderCustomer.getCode())
                .dateOrder(orderCustomer.getDateOrder())
                .idCompanies(orderCustomer.getIdCompanies())
                .build();
    }

    public static OrderCustomer toEntity(OrderCustomerDto orderCustomerDto) {
        if (orderCustomerDto == null) {
            //TODO throw an exception
            return null;
        }

        OrderCustomer orderCustomer = new OrderCustomer();
        orderCustomer.setCode(orderCustomer.getCode());
        orderCustomer.setDateOrder(orderCustomer.getDateOrder());
        orderCustomer.setIdCompanies(orderCustomerDto.getIdCompanies());
        return orderCustomer;
    }
}
