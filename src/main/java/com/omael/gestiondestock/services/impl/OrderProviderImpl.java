package com.omael.gestiondestock.services.impl;

import com.omael.gestiondestock.dto.LineOrderProviderDto;
import com.omael.gestiondestock.dto.OrderProviderDto;
import com.omael.gestiondestock.exception.EntityNotFoundException;
import com.omael.gestiondestock.exception.ErrorCodes;
import com.omael.gestiondestock.exception.InvalidEntityException;
import com.omael.gestiondestock.model.Article;
import com.omael.gestiondestock.model.Provider;
import com.omael.gestiondestock.model.LineOrderProvider;
import com.omael.gestiondestock.model.OrderProvider;
import com.omael.gestiondestock.repository.ArticleRepository;
import com.omael.gestiondestock.repository.LineOrderProviderRepository;
import com.omael.gestiondestock.repository.OrderProviderRepository;
import com.omael.gestiondestock.repository.ProviderRepository;
import com.omael.gestiondestock.services.OrderProviderService;
import com.omael.gestiondestock.validator.OrderProviderValidator;
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
public class OrderProviderImpl implements OrderProviderService {
    
    private final OrderProviderRepository orderProviderRepository;

    private final ProviderRepository providerRepository;

    private final ArticleRepository articleRepository;

    private final LineOrderProviderRepository lineOrderProviderRepository;

    @Autowired
    public OrderProviderImpl(OrderProviderRepository orderProviderRepository, ProviderRepository providerRepository, ArticleRepository articleRepository, LineOrderProviderRepository lineOrderProviderRepository) {
        this.orderProviderRepository = orderProviderRepository;
        this.providerRepository = providerRepository;
        this.articleRepository = articleRepository;
        this.lineOrderProviderRepository = lineOrderProviderRepository;
    }

    @Override
    public OrderProviderDto save(OrderProviderDto orderProviderDto) {

        List<String> errors = OrderProviderValidator.validate(orderProviderDto);

        if (!errors.isEmpty()) {
            log.error("Order provider is not valid");
            throw new InvalidEntityException("Order provider is not valid", ErrorCodes.ORDER_CUSTOMER_NOT_VALID, errors);
        }

        Optional<Provider> provider = this.providerRepository.findById(orderProviderDto.getProvider().getId());

        if (provider.isEmpty()) {
            log.warn("Client with ID {} not found", orderProviderDto.getProvider().getId());
            throw new EntityNotFoundException("Provider is with ID "+ orderProviderDto.getProvider().getId() +" not found", ErrorCodes.PROVIDER_NOT_VALID);
        }

        List<String> articleErrors = new ArrayList<>();
        if (orderProviderDto.getLineOrderProviders() != null) {
            orderProviderDto.getLineOrderProviders().forEach(lineOrderProviderDto -> {
                if (lineOrderProviderDto.getArticle() != null) {
                    Optional<Article> article = this.articleRepository.findById(lineOrderProviderDto.getArticle().getId());

                    if (article.isEmpty()) {
                        articleErrors.add("Article with ID " + lineOrderProviderDto.getArticle().getId() + " is not found");
                    }
                } else {
                    articleErrors.add("Error not save null article");
                }
            });

        }

        if (!articleErrors.isEmpty()) {
            log.warn("Article(s) not found");
            throw new InvalidEntityException("Article(s) not found", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }

        OrderProvider savedOrderProvider = this.orderProviderRepository.save(OrderProviderDto.toEntity(orderProviderDto));

        orderProviderDto.getLineOrderProviders().forEach( lineOrderProviderDto -> {
            LineOrderProvider lineOrderProvider = LineOrderProviderDto.toEntity(lineOrderProviderDto);
            lineOrderProvider.setOrderProvider(savedOrderProvider);
            this.lineOrderProviderRepository.save(lineOrderProvider);
        });

        return OrderProviderDto.fromEntity(savedOrderProvider);
    }

    @Override
    public OrderProviderDto findById(Integer orderProviderId) {
        if (orderProviderId == null) {
            log.error("Order Provider ID not is empty");
            return null;
        }
        return this.orderProviderRepository.findById(orderProviderId)
                .map(OrderProviderDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Order Provider with ID "+ orderProviderId +" not found", ErrorCodes.ORDER_CUSTOMER_NOT_FOUND));
    }

    @Override
    public OrderProviderDto findOrderProviderByCode(String codeOrderProvider) {
        if (!StringUtils.hasLength(codeOrderProvider)) {
            log.error("Order Provider CODE not is empty");
            return null;
        }
        return  this.orderProviderRepository.findOrderProviderByCode(codeOrderProvider)
                .map(OrderProviderDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Order Provider with CODE "+ codeOrderProvider +" not found", ErrorCodes.ORDER_CUSTOMER_NOT_FOUND));
    }

    @Override
    public List<OrderProviderDto> findAll() {
        return this.orderProviderRepository.findAll()
                .stream()
                .map(OrderProviderDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer orderProviderId) {
        if (orderProviderId == null) {
            log.error("Order Provider ID not is empty");
            return;
        }

        this.orderProviderRepository.deleteById(orderProviderId);
    }

}
