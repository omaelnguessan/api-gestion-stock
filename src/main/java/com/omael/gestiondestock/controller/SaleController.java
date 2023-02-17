package com.omael.gestiondestock.controller;

import com.omael.gestiondestock.controller.api.SaleApi;
import com.omael.gestiondestock.dto.SaleDto;
import com.omael.gestiondestock.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaleController implements SaleApi {

    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @Override
    public SaleDto save(SaleDto saleDto) {
        return this.saleService.save(saleDto);
    }

    @Override
    public SaleDto findById(Integer saleId) {
        return this.saleService.findById(saleId);
    }

    @Override
    public SaleDto findByCode(String code) {
        return this.saleService.findByCode(code);
    }

    @Override
    public List<SaleDto> findAll() {
        return this.saleService.findAll();
    }

    @Override
    public void delete(Integer saleId) {
        this.saleService.delete(saleId);
    }
}
