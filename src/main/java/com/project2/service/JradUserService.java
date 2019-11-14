package com.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.model.JradUser;
import com.project2.repository.JradUserRepository;

@Service
public class JradUserService {
	
	@Autowired
	private JradUserRepository jradUserRepository;
	
	public List<JradUser> findAll() {
		return jradUserRepository.findAll();
	}
}
