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

import com.project2.model.Post;
import com.project2.model.Status;
import com.project2.service.PostService;

@RestController
@CrossOrigin
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService ps;

	@PostMapping("/create/{post}")
	public void creation(@RequestBody Post post){
		ps.create(post);
	}

	@GetMapping("/all")
	public List<Post> getAllPost(){
		return ps.findAll();
	}

	@GetMapping("/retrieveStatus/{status}")
	public List<Post> getPostWithStatus(@PathVariable String status){
		return ps.findByStatus(status);
	}

	@PostMapping("/edittitle/{title}/{id}")
	public void editTitle(@RequestBody int id, String title){
		ps.updateTitleById(id, title);
	}

	@PostMapping("/editcontent/{content}/{id}")
	public void editContent(@RequestBody int id, String content){
		ps.updateContentById(id, content);
	}

	@PostMapping("/editstatus/{status}/{id}")
	public void editStatus(@RequestBody int id, Status status){
		ps.updateStatusById(id, status);
	}

	@PostMapping("/delete/{id}")
	public void delete(@RequestBody int id){
		ps.deleteById(id);
	}

}
