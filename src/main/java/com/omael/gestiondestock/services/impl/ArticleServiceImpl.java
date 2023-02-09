package com.omael.gestiondestock.services.impl;

import com.omael.gestiondestock.dto.ArticleDto;
import com.omael.gestiondestock.exception.EntityNotFoundException;
import com.omael.gestiondestock.exception.ErrorCodes;
import com.omael.gestiondestock.exception.InvalidEntityException;
import com.omael.gestiondestock.model.Article;
import com.omael.gestiondestock.repository.ArticleRepository;
import com.omael.gestiondestock.services.ArticleService;
import com.omael.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);

        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", articleDto);
            throw new InvalidEntityException("Erreur lors de la validation de l'article", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }

        return ArticleDto.fromEntity(
                this.articleRepository.save(
                        ArticleDto.toEntity(articleDto)
                )
        );
    }

    @Override
    public ArticleDto findById(Integer articleId) {
        if (articleId == null) {
            log.error("Article ID is null");
            return null;
        }
        Optional<Article> article = this.articleRepository.findById(articleId);

        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() -> new EntityNotFoundException("Article not found with ID  "+articleId, ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)) {
            log.error("Article CODE is null");
            return null;
        }
        Optional<Article> article = this.articleRepository.findArticleByCodeArticle(codeArticle);

        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() -> new EntityNotFoundException("Article not found with CODE  "+codeArticle, ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public List<ArticleDto> findAll() {
        return this.articleRepository.findAll()
                .stream().map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer articleId) {
        if (articleId == null) {
            log.error("Article ID is null");
            return;
        }
        this.articleRepository.deleteById(articleId);
    }
}
