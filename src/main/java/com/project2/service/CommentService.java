package com.project2.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project2.model.Comment;
import com.project2.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;

	//This was created so we can manipulate Entities or Models
	//https://www.tutorialspoint.com/jpa/jpa_entity_managers.htm
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	EntityManager entityManager = entityManagerFactory.createEntityManager( );

	//Create
	@Transactional
	public boolean insert(Comment comment){

		try {
			this.entityManager.persist(comment);
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

	//The update is messed up I'm still thinking on how to implement this
	//right, May ask questions for id's
	//Update
	public boolean updateContentById(int id, String content){

		if(commentRepository.existsById(id)){
			Comment comment = commentRepository.findById(id).get();
			comment.setContent(content);
			insert(comment);
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
