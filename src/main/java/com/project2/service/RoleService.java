package com.project2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.model.Role;
import com.project2.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	public Optional<Role> findById(int id) {
		return roleRepository.findById(id);
	}
	
	public Role findByRole(String role) {
		return roleRepository.findByRole(role);
	}
	
	public Role updateRole(Role role) {
		return roleRepository.save(role);
	}
	
	public Role create(Role role) {
		return roleRepository.save(role);
	}
}
