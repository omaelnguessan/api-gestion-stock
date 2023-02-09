package com.omael.gestiondestock.controller;

import com.omael.gestiondestock.controller.api.CustomerApi;
import com.omael.gestiondestock.dto.CustomerDto;
import com.omael.gestiondestock.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController implements CustomerApi {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return this.customerService.save(customerDto);
    }

    @Override
    public CustomerDto findById(Integer customerId) {
        return this.customerService.findById(customerId);
    }

    @Override
    public List<CustomerDto> findAll() {
        return this.customerService.findAll();
    }

    @Override
    public void delete(Integer customerId) {
        this.customerService.delete(customerId);
    }
}
