package com.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

	@GetMapping("/id/{id}")
	public Optional<Role> findById(@PathVariable int id) {
		return rs.findById(id);
	}

	// @GetMapping("/status/{role}")
	// public Role getStatus(@PathVariable String role) {
	// 		return rs.findByStatus(role);
	}

}
