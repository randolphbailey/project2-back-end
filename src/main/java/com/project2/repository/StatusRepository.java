package com.project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
	Status findByStatus(String status);
}
