package com.project2.service;

import java.util.List;
import java.util.Optional;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project2.model.JradUser;
import com.project2.model.Post;
import com.project2.model.Status;
import com.project2.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post create(Post post) {
		post.setCreated(new Timestamp(System.currentTimeMillis()));
		return postRepository.save(post);
	}

	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public List<Post> findByStatus(Status status) {
		return postRepository.findByStatus(status);
	}
	
	public List<Post> findByUser(JradUser user) {
		return postRepository.findByjradUser(user);
	}

	// Update
	public boolean updateTitleById(int id, String title) {

		if (postRepository.existsById(id)) {
			Post post = postRepository.findById(id).get();
			post.setTitle(title);
			create(post);
			return true;
		} else {
			return false;
		}
	}

	public boolean updateContentById(int id, String content) {

		if (postRepository.existsById(id)) {
			Post post = postRepository.findById(id).get();
			post.setContent(content);
			create(post);
			return true;
		} else {
			return false;
		}
	}

	public boolean updateStatusById(int id, Status status) {

		if (postRepository.existsById(id)) {
			Post post = postRepository.findById(id).get();
			post.setStatus(status);
			create(post);
			return true;
		} else {
			return false;
		}
	}

	// Delete
	public boolean deleteById(int id) {

		if (postRepository.existsById(id)) {
			postRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(Post post) {
		if (postRepository.existsById(post.getId())) {
			postRepository.delete(post);
			return true;
		} else {
			return false;
		}
	}

	public Optional<Post> getById(int id) {
		return postRepository.findById(id);
	}
}
