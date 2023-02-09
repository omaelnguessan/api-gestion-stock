package com.omael.gestiondestock.controller;

import com.omael.gestiondestock.controller.api.ProviderApi;
import com.omael.gestiondestock.dto.ProviderDto;
import com.omael.gestiondestock.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProviderController implements ProviderApi {

    private final ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @Override
    public ProviderDto save(ProviderDto providerDto) {
        return this.providerService.save(providerDto);
    }

    @Override
    public ProviderDto findById(Integer providerId) {
        return this.providerService.findById(providerId);
    }

    @Override
    public List<ProviderDto> findAll() {
        return this.providerService.findAll();
    }

    @Override
    public void delete(Integer providerId) {
        this.providerService.delete(providerId);
    }
}
