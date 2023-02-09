package com.omael.gestiondestock.services;

import com.omael.gestiondestock.dto.OrderCustomerDto;

import java.util.List;

public interface OrderCustomerService {

    OrderCustomerDto save(OrderCustomerDto orderCustomerDto);

    OrderCustomerDto findById(Integer orderCustomerId);

    OrderCustomerDto findOrderCustomerByCode(String codeOrderCustomer);

    List<OrderCustomerDto> findAll();

    void delete(Integer orderCustomerId);
}
