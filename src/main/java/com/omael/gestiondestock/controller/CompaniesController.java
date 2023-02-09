package com.omael.gestiondestock.controller;

import com.omael.gestiondestock.controller.api.CompaniesApi;
import com.omael.gestiondestock.dto.CompaniesDto;
import com.omael.gestiondestock.services.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompaniesController implements CompaniesApi {

    private final CompaniesService companiesService;

    @Autowired
    public CompaniesController(CompaniesService companiesService) {
        this.companiesService = companiesService;
    }

    @Override
    public CompaniesDto save(CompaniesDto companiesDto) {
        return this.companiesService.save(companiesDto);
    }

    @Override
    public CompaniesDto findById(Integer companiesId) {
        return this.companiesService.findById(companiesId);
    }

    @Override
    public List<CompaniesDto> findAll() {
        return this.companiesService.findAll();
    }

    @Override
    public void delete(Integer companiesId) {
        this.companiesService.delete(companiesId);
    }
}
