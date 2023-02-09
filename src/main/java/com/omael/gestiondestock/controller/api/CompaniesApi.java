package com.omael.gestiondestock.controller.api;

import com.omael.gestiondestock.dto.CompaniesDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.omael.gestiondestock.utils.Constants.APP_ROOT;

public interface CompaniesApi {
    @PostMapping(value = APP_ROOT + "/companies/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CompaniesDto save(@RequestBody CompaniesDto companiesDto);

    @GetMapping(value = APP_ROOT + "/companies/{companiesId}", produces = MediaType.APPLICATION_JSON_VALUE)
    CompaniesDto findById(@PathVariable("companiesId") Integer companiesId);

    @GetMapping(value = APP_ROOT + "/companies/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CompaniesDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/companies/delete/{companiesId}")
    void delete(@PathVariable("companiesId") Integer companiesId);
}
