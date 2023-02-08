package com.omael.gestiondestock.services;

import com.omael.gestiondestock.dto.ArticleDto;
import com.omael.gestiondestock.model.Article;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto articleDto);

    ArticleDto findById(Integer articleId);

    ArticleDto findByCodeArticle(String codeArticle);

    List<ArticleDto> findAll();

    void delete(Integer articleId);
}
