package com.omael.gestiondestock.repository;

import com.omael.gestiondestock.model.Companies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompaniesRepository extends JpaRepository<Companies, Integer> {
}
