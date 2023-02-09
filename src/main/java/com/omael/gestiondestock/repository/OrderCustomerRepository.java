package com.omael.gestiondestock.repository;

import com.omael.gestiondestock.model.OrderCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderCustomerRepository extends JpaRepository<OrderCustomer, Integer> {
    Optional<OrderCustomer> findOrderCustomerByCode(String codeOrderCustomer);
}
