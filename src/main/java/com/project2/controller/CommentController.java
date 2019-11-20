package com.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.project2.model.Comment;
import com.project2.model.Post;
import com.project2.service.CommentService;
import com.project2.service.PostService;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService cs;
	
	@Autowired
	private PostService ps;

	@PostMapping("/create")
	public void create(@RequestBody Comment comment) {
		cs.create(comment);
	}

	@GetMapping("/all")
	public List<Comment> getAllComment() {
		return cs.findAll();
	}

	@GetMapping("/getById/{id}")
	public Optional<Comment> getCommentById(@PathVariable int id) {
		return cs.findById(id);
	}
	
	@GetMapping("/getByPost/{id}")
	public List<Comment> getCommentsByPost(@PathVariable int id) {
		return cs.findByPost(ps.getById(id).get());
	}

	@PostMapping("/update")
	public void updateComment(@RequestBody Comment comment) {
		cs.save(comment);
	}

	@PostMapping("/delete")
	public void delete(@RequestBody Comment comment) {
		cs.delete(comment);
	}

}
