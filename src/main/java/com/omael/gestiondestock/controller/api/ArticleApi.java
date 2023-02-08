package com.omael.gestiondestock.controller.api;

import com.omael.gestiondestock.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.omael.gestiondestock.utils.Constants.APP_ROOT;

public interface ArticleApi {

    @PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody ArticleDto articleDto);

    @GetMapping(value = APP_ROOT + "/articles/{articleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("articleId") Integer articleId);

    @GetMapping(value = APP_ROOT + "/articles/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);

    @GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/articles/delete/{articleId}")
    void delete(@PathVariable("articleId") Integer articleId);
}
