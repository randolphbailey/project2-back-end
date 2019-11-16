package com.project2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.model.Role;
import com.project2.service.RoleService;

@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService rs;

	@GetMapping("/all")
	public List<Role> getAllRole(){
		return rs.findAll();
	}

	@GetMapping("/getById/{id}")
	public Optional<Role> findById(@PathVariable int id) {
		return rs.findById(id);
	}
	
	@GetMapping("/getByRole/{role}")
	public Role getByRole(@PathVariable String role) {
		return rs.findByRole(role);
	}
	
	@PostMapping("/create")
	public Role create(@RequestBody Role role) {
		return rs.create(role);
	}
}
