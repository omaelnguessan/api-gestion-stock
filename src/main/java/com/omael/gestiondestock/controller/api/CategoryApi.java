package com.omael.gestiondestock.controller.api;

import com.omael.gestiondestock.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.omael.gestiondestock.utils.Constants.APP_ROOT;


public interface CategoryApi {

    @PostMapping(value = APP_ROOT + "/category/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto categoryDto);

    @GetMapping(value = APP_ROOT + "/category/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("categoryId") Integer categoryId);

    @GetMapping(value = APP_ROOT + "/category/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCodeArticle(@PathVariable("codeCategory") String codeCategory);

    @GetMapping(value = APP_ROOT + "/category/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/category/delete/{categoryId}")
    void delete(@PathVariable("categoryId") Integer categoryId);
}
