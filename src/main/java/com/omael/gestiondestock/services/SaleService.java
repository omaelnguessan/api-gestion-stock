package com.omael.gestiondestock.services;

import com.omael.gestiondestock.dto.SaleDto;

import java.util.List;

public interface SaleService {

    SaleDto save(SaleDto saleDto);

    SaleDto findById(Integer saleId);

    SaleDto findByCode(String code);

    List<SaleDto> findAll();

    void delete(Integer saleId);
}
