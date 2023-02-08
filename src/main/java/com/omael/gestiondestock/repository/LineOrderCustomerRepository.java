package com.omael.gestiondestock.repository;

import com.omael.gestiondestock.model.LineOrderCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineOrderCustomerRepository extends JpaRepository<LineOrderCustomer, Integer> {
}
