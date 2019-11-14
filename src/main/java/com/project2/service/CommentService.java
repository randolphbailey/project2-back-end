package com.project2.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project2.model.Comment;
import com.project2.model.Post;
import com.project2.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;


	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	// Create
	@Transactional
	public boolean create(Comment comment) {

		try {
			comment.setCreated(timestamp);
			commentRepository.save(comment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	@Transactional
	public boolean save(Comment comment) {

		try {
			commentRepository.save(comment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//Read
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}
	
	public Optional<Comment> findById(int id) {
		return commentRepository.findById(id);
	}

	//Update
	public boolean updateContentById(int id, String content){

		if(commentRepository.existsById(id)){
			Comment comment = commentRepository.findById(id).get();
			comment.setContent(content);
			save(comment);
			return true;
		}else{
			return false;
		}
	}

	public boolean updatePostById(int id, Post post){

		if(commentRepository.existsById(id)){
			Comment comment = commentRepository.findById(id).get();
			comment.setPost(post);
			save(comment);
			return true;
		}else{
			return false;
		}
	}

	//Delete
	public boolean deleteById(int id){
		
		if(commentRepository.existsById(id)){
			commentRepository.deleteById(id);
			return true;
		} else{
			return false;
		}		
	}

	


}
