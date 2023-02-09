package com.omael.gestiondestock.services.impl;

import com.omael.gestiondestock.dto.ProviderDto;
import com.omael.gestiondestock.exception.EntityNotFoundException;
import com.omael.gestiondestock.exception.ErrorCodes;
import com.omael.gestiondestock.exception.InvalidEntityException;
import com.omael.gestiondestock.model.Provider;
import com.omael.gestiondestock.repository.ProviderRepository;
import com.omael.gestiondestock.services.ProviderService;
import com.omael.gestiondestock.validator.ProviderValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;

    @Autowired
    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public ProviderDto save(ProviderDto providerDto) {
        List<String> errors = ProviderValidator.validate(providerDto);

        if (!errors.isEmpty()) {
            log.error("Invalid provider {}", providerDto);
            throw new InvalidEntityException("Invalid provider", ErrorCodes.PROVIDER_NOT_VALID, errors);
        }

        return ProviderDto.fromEntity(
                this.providerRepository.save(
                        ProviderDto.toEntity(providerDto)
                )
        );
    }

    @Override
    public ProviderDto findById(Integer providerId) {
        if (providerId == null) {
            log.error("Provider ID not is empty");
            return null;
        }
        Optional<Provider> provider = this.providerRepository.findById(providerId);

        return Optional.of(ProviderDto.fromEntity(provider.get()))
                .orElseThrow(() -> new EntityNotFoundException("Provider with ID "+ providerId +" not found", ErrorCodes.PROVIDER_NOT_FOUND));
    }

    @Override
    public List<ProviderDto> findAll() {
        return this.providerRepository.findAll()
                .stream().
                map(ProviderDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer providerId) {
        this.providerRepository.deleteById(providerId);
    }
}
