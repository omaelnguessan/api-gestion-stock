package com.omael.gestiondestock.services;

import com.omael.gestiondestock.dto.CompaniesDto;

import java.util.List;

public interface CompaniesService {
    
    CompaniesDto save(CompaniesDto companiesDto);

    CompaniesDto findById(Integer companiesId);

    List<CompaniesDto> findAll();

    void delete(Integer companiesId);
}
