package com.omael.gestiondestock.repository;

import com.omael.gestiondestock.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Integer, Provider> {
}
