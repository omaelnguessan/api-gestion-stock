package com.omael.gestiondestock.repository;

import com.omael.gestiondestock.model.OrderProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderProviderRepository extends JpaRepository<OrderProvider, Integer> {

    Optional<OrderProvider> findOrderProviderByCode(String codeOrderProvider);
}
