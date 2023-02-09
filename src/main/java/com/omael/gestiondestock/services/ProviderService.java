package com.omael.gestiondestock.services;

import com.omael.gestiondestock.dto.ProviderDto;

import java.util.List;

public interface ProviderService {

    ProviderDto save(ProviderDto providerDto);

    ProviderDto findById(Integer providerId);

    List<ProviderDto> findAll();

    void delete(Integer providerId);
}
