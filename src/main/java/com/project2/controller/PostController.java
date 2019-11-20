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

import com.project2.model.Post;
import com.project2.model.Status;
import com.project2.service.JradUserService;
import com.project2.service.PostService;
import com.project2.service.StatusService;

@RestController
@CrossOrigin
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService ps;
	
	@Autowired
	private StatusService ss;
	
	@Autowired
	private JradUserService us;

	@PostMapping("/create")
	public Post creation(@RequestBody Post post){
		return ps.create(post);
	}

	@GetMapping("/all")
	public List<Post> getAllPost(){
		return ps.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Post> getById(@PathVariable int id) {
		return ps.getById(id);
	}

	@GetMapping("/getByStatus/{status}")
	public List<Post> getPostWithStatus(@PathVariable String status){
		return ps.findByStatus(ss.findByStatus(status));
	}
	
	@GetMapping("/getByUser/{username}")
	public List<Post> getPostByUser(@PathVariable String username) {
		return ps.findByUser(us.findUserByUsername(username));
	}

	@PostMapping("/update")
	public void editTitle(@RequestBody Post post){
		ps.create(post);
	}

	@PostMapping("/delete")
	public void delete(@RequestBody Post post){
		ps.delete(post);
	}

}
