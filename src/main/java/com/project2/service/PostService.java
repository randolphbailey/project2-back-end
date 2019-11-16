package com.project2.service;

import java.util.List;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project2.model.Post;
import com.project2.model.Status;
import com.project2.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	// Create
	@Transactional
	public boolean create(Post post) {

		try {
			post.setCreated(new Timestamp(System.currentTimeMillis()));
			postRepository.save(post);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	@Transactional
	public boolean save(Post post) {

		try {
			postRepository.save(post);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//Read
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public List<Post> findByStatus(String status){
		return postRepository.findByStatus(status);
	}

	//Update
	public boolean updateTitleById(int id, String title){

		if(postRepository.existsById(id)){
			Post post = postRepository.findById(id).get();
			post.setTitle(title);
			save(post);
			return true;
		}else{
			return false;
		}
	}

	public boolean updateContentById(int id, String content){

		if(postRepository.existsById(id)){
			Post post = postRepository.findById(id).get();
			post.setContent(content);
			save(post);
			return true;
		}else{
			return false;
		}
	}

	public boolean updateStatusById(int id, Status status){

		if(postRepository.existsById(id)){
			Post post = postRepository.findById(id).get();
			post.setStatus(status);
			save(post);
			return true;
		}else{
			return false;
		}
	}

	//Delete
	public boolean deleteById(int id){
		
		if(postRepository.existsById(id)){
			postRepository.deleteById(id);
			return true;
		} else{
			return false;
		}		
	}

	public boolean delete(Post post){
		if(postRepository.existsById(post.getId())){
			postRepository.delete(post);
			return true;
		} else{
			return false;
		}		
	}
}
