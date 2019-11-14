package com.project2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.model.Comment;
import com.project2.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}
	
	public Optional<Comment> findById(int id) {
		return commentRepository.findById(id);
	}
}
