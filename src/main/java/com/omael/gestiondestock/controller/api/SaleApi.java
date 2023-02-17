package com.omael.gestiondestock.controller.api;

import com.omael.gestiondestock.dto.SaleDto;

import java.util.List;

public interface SaleApi {

    SaleDto save(SaleDto saleDto);

    SaleDto findById(Integer saleId);

    SaleDto findByCode(String code);

    List<SaleDto> findAll();

    void delete(Integer saleId);
}
