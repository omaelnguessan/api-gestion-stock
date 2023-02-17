package com.omael.gestiondestock.repository;

import com.omael.gestiondestock.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
    Optional<Sale> findByCode(String code);
}
