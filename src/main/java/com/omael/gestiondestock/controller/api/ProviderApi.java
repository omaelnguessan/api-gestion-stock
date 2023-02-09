package com.omael.gestiondestock.controller.api;

import com.omael.gestiondestock.dto.ProviderDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.omael.gestiondestock.utils.Constants.APP_ROOT;

public interface ProviderApi {

    @PostMapping(value = APP_ROOT + "/providers/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ProviderDto save(@RequestBody ProviderDto providerDto);

    @GetMapping(value = APP_ROOT + "/providers/{providerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ProviderDto findById(@PathVariable("providerId") Integer providerId);

    @GetMapping(value = APP_ROOT + "/providers/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProviderDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/providers/delete/{providerId}")
    void delete(@PathVariable("providerId") Integer providerId);
}
