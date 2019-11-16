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

import com.project2.model.Status;
import com.project2.service.StatusService;

@RestController
@CrossOrigin
@RequestMapping("/status")
public class StatusController {

	@Autowired
	private StatusService ss;
	
	@GetMapping("/all")
	public List<Status> getAllStatus(){
		return ss.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Optional<Status> getStatusById(@PathVariable int id) {
		return ss.findById(id);
	}
	
	@GetMapping("/{status}")
	public Status getStatusByStatus(@PathVariable String status) {
		return ss.findByStatus(status);
	}
	
	@PostMapping("/add")
	public Status addStatus(@RequestBody Status status) {
		return ss.newStatus(status);
	}
}
