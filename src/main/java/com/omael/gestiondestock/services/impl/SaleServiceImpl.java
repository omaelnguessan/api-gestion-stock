package com.omael.gestiondestock.services.impl;

import com.omael.gestiondestock.dto.LineSaleDto;
import com.omael.gestiondestock.dto.SaleDto;
import com.omael.gestiondestock.exception.EntityNotFoundException;
import com.omael.gestiondestock.exception.ErrorCodes;
import com.omael.gestiondestock.exception.InvalidEntityException;
import com.omael.gestiondestock.model.Article;
import com.omael.gestiondestock.model.LineSale;
import com.omael.gestiondestock.model.Sale;
import com.omael.gestiondestock.repository.ArticleRepository;
import com.omael.gestiondestock.repository.LineSaleRepository;
import com.omael.gestiondestock.repository.SaleRepository;
import com.omael.gestiondestock.services.SaleService;
import com.omael.gestiondestock.validator.SaleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SaleServiceImpl implements SaleService {

    private final ArticleRepository articleRepository;
    private final SaleRepository saleRepository;
    private final LineSaleRepository lineSaleRepository;

    @Autowired
    public SaleServiceImpl(ArticleRepository articleRepository, SaleRepository saleRepository, LineSaleRepository lineSaleRepository) {
        this.articleRepository = articleRepository;
        this.saleRepository = saleRepository;
        this.lineSaleRepository = lineSaleRepository;
    }

    @Override
    public SaleDto save(SaleDto saleDto) {
        List<String> errors = SaleValidator.validate(saleDto);

        if (!errors.isEmpty()) {
            log.error("Sale not valid");
            throw new InvalidEntityException("Error invalid sale", ErrorCodes.SALE_NOT_VALID);
        }

        List<String> articleErrors = new ArrayList<>();

        saleDto.getLineSales().forEach(lineSaleDto -> {
            Optional<Article> article = articleRepository.findById(lineSaleDto.getArticle().getId());
            if (article.isEmpty()) {
                articleErrors.add("Article with ID "+lineSaleDto.getArticle().getId()+" not found");
            }
        });

        if (!articleErrors.isEmpty()) {
            log.error("One or More articles were not found {}", articleErrors);
            throw new InvalidEntityException("One or More articles were not found ", ErrorCodes.SALE_NOT_VALID);
        }

        Sale savedSale = saleRepository.save(SaleDto.toEntity(saleDto));

        saleDto.getLineSales().forEach(lineSaleDto -> {
            LineSale lineSale = LineSaleDto.toEntity(lineSaleDto);
            lineSale.setSale(savedSale);
            lineSaleRepository.save(lineSale);
        });

        return SaleDto.fromEntity(savedSale);
    }

    @Override
    public SaleDto findById(Integer saleId) {
        if (saleId == null) {
            log.error("Sale ID not is empty");
            return null;
        }
        return saleRepository.findById(saleId).map(SaleDto::fromEntity).orElseThrow(() -> new EntityNotFoundException("Sale with ID "+saleId+" not found", ErrorCodes.SALE_NOT_FOUND));
    }

    @Override
    public SaleDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Sale CODE not is empty");
            return null;
        }
        return saleRepository.findByCode(code).map(SaleDto::fromEntity).orElseThrow(() -> new EntityNotFoundException("Sale with CODE "+code+" not found", ErrorCodes.SALE_NOT_FOUND));
    }

    @Override
    public List<SaleDto> findAll() {
        return saleRepository.findAll().stream()
                .map(SaleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer saleId) {
        if (saleId == null) {
            log.error("Sale ID not is empty");
            return;
        }
        saleRepository.deleteById(saleId);
    }
}
