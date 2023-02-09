package com.omael.gestiondestock.controller.api;

import com.omael.gestiondestock.dto.CustomerDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.omael.gestiondestock.utils.Constants.APP_ROOT;

public interface CustomerApi {

    @PostMapping(value = APP_ROOT + "/customers/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerDto save(@RequestBody CustomerDto customerDto);

    @GetMapping(value = APP_ROOT + "/customers/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerDto findById(@PathVariable("customerId") Integer customerId);

    @GetMapping(value = APP_ROOT + "/customers/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CustomerDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/customers/delete/{customerId}")
    void delete(@PathVariable("customerId") Integer customerId);
}
