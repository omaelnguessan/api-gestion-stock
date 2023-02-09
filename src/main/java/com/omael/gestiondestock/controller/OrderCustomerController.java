package com.omael.gestiondestock.controller;

import com.omael.gestiondestock.controller.api.OrderCustomerApi;
import com.omael.gestiondestock.dto.OrderCustomerDto;
import com.omael.gestiondestock.services.OrderCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderCustomerController implements OrderCustomerApi {

    private final OrderCustomerService orderCustomerService;

    @Autowired
    public OrderCustomerController(OrderCustomerService orderCustomerService) {
        this.orderCustomerService = orderCustomerService;
    }


    @Override
    public OrderCustomerDto save(OrderCustomerDto orderCustomerDto) {
        return this.orderCustomerService.save(orderCustomerDto);
    }

    @Override
    public OrderCustomerDto findById(Integer orderCustomerId) {
        return this.orderCustomerService.findById(orderCustomerId);
    }

    @Override
    public OrderCustomerDto findOrderCustomerByCode(String codeOrderCustomer) {
        return this.orderCustomerService.findOrderCustomerByCode(codeOrderCustomer);
    }

    @Override
    public List<OrderCustomerDto> findAll() {
        return this.orderCustomerService.findAll();
    }

    @Override
    public void delete(Integer orderCustomerId) {
        this.orderCustomerService.delete(orderCustomerId);
    }
}
