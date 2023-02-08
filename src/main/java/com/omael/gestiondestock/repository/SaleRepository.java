package com.omael.gestiondestock.repository;

import com.omael.gestiondestock.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
