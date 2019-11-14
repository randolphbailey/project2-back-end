package com.project2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.model.Status;
import com.project2.repository.StatusRepository;

@Service
public class StatusService {
	
	@Autowired
	private StatusRepository statusRepository;
	
	public List<Status> findAll() {
		return statusRepository.findAll();
	}
	
	public Optional<Status> findById(int id) {
		return statusRepository.findById(id);
	}
	
	public Status findByStatus(String status) {
		return statusRepository.findByStatus(status);
	}
}
