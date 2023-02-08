package com.omael.gestiondestock.repository;

import com.omael.gestiondestock.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
