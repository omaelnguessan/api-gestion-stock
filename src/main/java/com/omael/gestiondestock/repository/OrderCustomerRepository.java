package com.omael.gestiondestock.repository;

import com.omael.gestiondestock.model.OrderCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCustomerRepository extends JpaRepository<OrderCustomer, Integer> {
}
