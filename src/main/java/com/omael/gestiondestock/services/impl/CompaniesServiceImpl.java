package com.omael.gestiondestock.services.impl;

import com.omael.gestiondestock.dto.CompaniesDto;
import com.omael.gestiondestock.exception.EntityNotFoundException;
import com.omael.gestiondestock.exception.ErrorCodes;
import com.omael.gestiondestock.exception.InvalidEntityException;
import com.omael.gestiondestock.model.Companies;
import com.omael.gestiondestock.repository.CompaniesRepository;
import com.omael.gestiondestock.services.CompaniesService;
import com.omael.gestiondestock.validator.CompagniesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompaniesServiceImpl implements CompaniesService {

    private CompaniesRepository companiesRepository;

    @Autowired
    public CompaniesServiceImpl(CompaniesRepository companiesRepository) {
        this.companiesRepository = companiesRepository;
    }

    @Override
    public CompaniesDto save(CompaniesDto companiesDto) {
        List<String> errors = CompagniesValidator.validator(companiesDto);

        if (!errors.isEmpty()) {
            log.error("Companies is not valid {}", companiesDto);
            throw new InvalidEntityException("Erreur lors de la validation de la compagnie", ErrorCodes.COMPANIES_NOT_VALID);
        }

        return CompaniesDto.fromEntity(
                this.companiesRepository.save(
                        CompaniesDto.toEntity(companiesDto)
                )
        );
    }

    @Override
    public CompaniesDto findById(Integer companiesId) {
        if (companiesId == null) {
            log.error("Companies ID is null");
            return null;
        }

        Optional<Companies> companies = this.companiesRepository.findById(companiesId);

        return Optional.of(CompaniesDto
                .fromEntity(companies.get()))
                .orElseThrow(() ->  new EntityNotFoundException("Error category with ID "+companiesId+" not found", ErrorCodes.COMPANIES_NOT_FOUND));
    }


    @Override
    public List<CompaniesDto> findAll() {
        return this.companiesRepository.findAll()
                .stream()
                .map(CompaniesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer companiesId) {
        if (companiesId == null) {
            log.error("Companies ID is null");
            return;
        }

        this.companiesRepository.deleteById(companiesId);
    }
}
