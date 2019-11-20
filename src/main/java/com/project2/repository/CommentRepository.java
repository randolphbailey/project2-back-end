package com.project2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.model.Comment;
import com.project2.model.Post;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	List<Comment> findByPost(Post post);
}
