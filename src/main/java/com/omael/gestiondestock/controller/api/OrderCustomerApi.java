package com.omael.gestiondestock.controller.api;

import com.omael.gestiondestock.dto.OrderCustomerDto;

import java.util.List;

public interface OrderCustomerApi {

    OrderCustomerDto save(OrderCustomerDto orderCustomerDto);

    OrderCustomerDto findById(Integer orderCustomerId);

    OrderCustomerDto findOrderCustomerByCode(String codeOrderCustomer);

    List<OrderCustomerDto> findAll();

    void delete(Integer orderCustomerId);
}
