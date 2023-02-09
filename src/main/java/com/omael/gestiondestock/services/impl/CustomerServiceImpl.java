package com.omael.gestiondestock.services.impl;

import com.omael.gestiondestock.dto.CustomerDto;
import com.omael.gestiondestock.exception.EntityNotFoundException;
import com.omael.gestiondestock.exception.ErrorCodes;
import com.omael.gestiondestock.exception.InvalidEntityException;
import com.omael.gestiondestock.model.Customer;
import com.omael.gestiondestock.repository.CustomerRepository;
import com.omael.gestiondestock.services.CustomerService;
import com.omael.gestiondestock.validator.CustomerValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        List<String> errors = CustomerValidator.validate(customerDto);

        if (!errors.isEmpty()) {
            log.error("Customer is not valid {}", customerDto);
            throw new InvalidEntityException("Invalid customer", ErrorCodes.CUSTOMER_NOT_VALID, errors);
        }

        return CustomerDto.fromEntity(
                this.customerRepository.save(
                        CustomerDto.toEntity(customerDto)
                )
        );
    }

    @Override
    public CustomerDto findById(Integer customerId) {
        if (customerId == null) {
            log.error("Customer ID not is empty");
            return null;
        }

        Optional<Customer> customer = this.customerRepository.findById(customerId);

        return Optional.of(CustomerDto.fromEntity(customer.get())).orElseThrow(() -> new EntityNotFoundException("Customer with ID "+ customerId +" not found", ErrorCodes.CUSTOMER_NOT_FOUND));
    }

    @Override
    public List<CustomerDto> findAll() {
        return this.customerRepository.findAll()
                .stream()
                .map(CustomerDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer customerId) {
        if (customerId == null) {
            log.error("Customer ID not is empty");
            return;
        }

        this.customerRepository.deleteById(customerId);
    }
}
