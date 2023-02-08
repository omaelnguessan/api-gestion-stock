package com.omael.gestiondestock.repository;

import com.omael.gestiondestock.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
