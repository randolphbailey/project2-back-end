package com.project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>{

}
