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

import com.project2.model.JradUser;
import com.project2.model.Role;
import com.project2.service.JradUserService;

@RestController
@CrossOrigin
@RequestMapping("/jradUser")
public class JradUserController {

	@Autowired
	private JradUserService jus;

	@GetMapping("/create")
	public void create(@PathVariable JradUser user){
		jus.create(user);
	}

	@GetMapping("/all")
	public List<JradUser> getAllUser() {
		return jus.findAll();
	}

	@GetMapping("/getById/{id}")
	public Optional<JradUser> getUserById(@PathVariable int id) {
		return jus.findUserById(id);
	}

	@GetMapping("/getByUsername/{username}")
	public JradUser getUserByUsername(@PathVariable String username) {
		return jus.findUserByUsername(username);
	}

	@PostMapping("/update")
	public void edit(@RequestBody JradUser user){
		jus.save(user);
	}

	@PostMapping("/delete")
	public void delete(@RequestBody JradUser user){
		jus.delete(user);
	}

}
