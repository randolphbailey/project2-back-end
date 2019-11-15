package com.project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.model.JradUser;

@Repository
public interface JradUserRepository extends JpaRepository<JradUser, Integer>{
    JradUser findByUsername(String username);
}
