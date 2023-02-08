package com.omael.gestiondestock.controller;

import com.omael.gestiondestock.controller.api.ArticleApi;
import com.omael.gestiondestock.dto.ArticleDto;
import com.omael.gestiondestock.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        return this.articleService.save(articleDto);
    }

    @Override
    public ArticleDto findById(Integer articleId) {
        return this.articleService.findById(articleId);
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return this.articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public List<ArticleDto> findAll() {
        return this.articleService.findAll();
    }

    @Override
    public void delete(Integer articleId) {
        this.articleService.delete(articleId);
    }
}
