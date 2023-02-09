package com.omael.gestiondestock.services.impl;

import com.omael.gestiondestock.dto.LineOrderCustomerDto;
import com.omael.gestiondestock.dto.OrderCustomerDto;
import com.omael.gestiondestock.exception.EntityNotFoundException;
import com.omael.gestiondestock.exception.ErrorCodes;
import com.omael.gestiondestock.exception.InvalidEntityException;
import com.omael.gestiondestock.model.Article;
import com.omael.gestiondestock.model.Customer;
import com.omael.gestiondestock.model.LineOrderCustomer;
import com.omael.gestiondestock.model.OrderCustomer;
import com.omael.gestiondestock.repository.ArticleRepository;
import com.omael.gestiondestock.repository.CustomerRepository;
import com.omael.gestiondestock.repository.LineOrderCustomerRepository;
import com.omael.gestiondestock.repository.OrderCustomerRepository;
import com.omael.gestiondestock.services.OrderCustomerService;
import com.omael.gestiondestock.validator.OrderCustomerValidator;
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
public class OrderCustomerImpl implements OrderCustomerService {

    private final OrderCustomerRepository orderCustomerRepository;
    private final CustomerRepository customerRepository;
    private final ArticleRepository articleRepository;

    private final LineOrderCustomerRepository lineOrderCustomerRepository;

    @Autowired
    public OrderCustomerImpl(OrderCustomerRepository orderCustomerRepository, CustomerRepository customerRepository, ArticleRepository articleRepository, LineOrderCustomerRepository lineOrderCustomerRepository) {
        this.orderCustomerRepository = orderCustomerRepository;
        this.customerRepository = customerRepository;
        this.articleRepository = articleRepository;
        this.lineOrderCustomerRepository = lineOrderCustomerRepository;
    }


    @Override
    public OrderCustomerDto save(OrderCustomerDto orderCustomerDto) {

        List<String> errors = OrderCustomerValidator.validate(orderCustomerDto);

        if (!errors.isEmpty()) {
            log.error("Order customer is not valid");
            throw new InvalidEntityException("Order customer is not valid", ErrorCodes.ORDER_CUSTOMER_NOT_VALID, errors);
        }

        Optional<Customer> customer = this.customerRepository.findById(orderCustomerDto.getCustomer().getId());

        if (customer.isEmpty()) {
            log.warn("Client with ID {} not found", orderCustomerDto.getCustomer().getId());
            throw new EntityNotFoundException("Customer is with ID "+ orderCustomerDto.getCustomer().getId() +" not found", ErrorCodes.CUSTOMER_NOT_VALID);
        }

        List<String> articleErrors = new ArrayList<>();
        if (orderCustomerDto.getLineOrderCustomers() != null) {
            orderCustomerDto.getLineOrderCustomers().forEach(lineOrderCustomerDto -> {
                if (lineOrderCustomerDto.getArticle() != null) {
                    Optional<Article> article = this.articleRepository.findById(lineOrderCustomerDto.getArticle().getId());

                    if (article.isEmpty()) {
                        articleErrors.add("Article with ID " + lineOrderCustomerDto.getArticle().getId() + " is not found");
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

       OrderCustomer savedOrderCustomer = this.orderCustomerRepository.save(OrderCustomerDto.toEntity(orderCustomerDto));

        orderCustomerDto.getLineOrderCustomers().forEach( lineOrderCustomerDto -> {
            LineOrderCustomer lineOrderCustomer = LineOrderCustomerDto.toEntity(lineOrderCustomerDto);
            lineOrderCustomer.setOrderCustomer(savedOrderCustomer);
            this.lineOrderCustomerRepository.save(lineOrderCustomer);
        });

        return OrderCustomerDto.fromEntity(savedOrderCustomer);
    }

    @Override
    public OrderCustomerDto findById(Integer orderCustomerId) {
        if (orderCustomerId == null) {
            log.error("Order Customer ID not is empty");
            return null;
        }
        return this.orderCustomerRepository.findById(orderCustomerId)
                .map(OrderCustomerDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Order Customer with ID "+ orderCustomerId +" not found", ErrorCodes.ORDER_CUSTOMER_NOT_FOUND));
    }

    @Override
    public OrderCustomerDto findOrderCustomerByCode(String codeOrderCustomer) {
        if (!StringUtils.hasLength(codeOrderCustomer)) {
            log.error("Order Customer CODE not is empty");
            return null;
        }
        return  this.orderCustomerRepository.findOrderCustomerByCode(codeOrderCustomer)
                .map(OrderCustomerDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Order Customer with CODE "+ codeOrderCustomer +" not found", ErrorCodes.ORDER_CUSTOMER_NOT_FOUND));
    }

    @Override
    public List<OrderCustomerDto> findAll() {
        return this.orderCustomerRepository.findAll()
                .stream()
                .map(OrderCustomerDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer orderCustomerId) {
        if (orderCustomerId == null) {
            log.error("Order Customer ID not is empty");
            return;
        }

        this.orderCustomerRepository.deleteById(orderCustomerId);
    }
}
