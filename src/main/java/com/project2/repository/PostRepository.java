package com.project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.project2.model.JradUser;
import com.project2.model.Post;
import com.project2.model.Status;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
    List<Post> findByStatus(Status status);
    List<Post> findByjradUser(JradUser jradUser);
}
