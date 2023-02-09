package com.omael.gestiondestock.services;

import com.omael.gestiondestock.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto save(CustomerDto customerDto);

    CustomerDto findById(Integer customerId);

    List<CustomerDto> findAll();

    void delete(Integer customerId);
}
