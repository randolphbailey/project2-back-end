package com.project2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.apache.commons.codec.digest.DigestUtils;

import com.project2.model.JradUser;
import com.project2.model.Role;
import com.project2.repository.JradUserRepository;

@Service
public class JradUserService {

	@Autowired
	private JradUserRepository jradUserRepository;

	public JradUser create(JradUser user) {
		user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
		return jradUserRepository.save(user);
	}

	public List<JradUser> findAll() {
		return jradUserRepository.findAll();
	}

	public Optional<JradUser> findUserById(int id) {
		return jradUserRepository.findById(id);
	}

	public JradUser findUserByUsername(String username) {
		return jradUserRepository.findByUsername(username);
	}

	public int findIdByUsername(String username) {
		return findUserByUsername(username).getId();
	}

	// Update
	public boolean updatePasswordById(int id, String password) {

		if (jradUserRepository.existsById(id)) {
			JradUser user = jradUserRepository.findById(id).get();
			user.setPassword(DigestUtils.sha256Hex(password));
			jradUserRepository.save(user);
			return true;
		} else {
			return false;
		}
	}

	public boolean updateFirstNameById(int id, String FirstName) {

		if (jradUserRepository.existsById(id)) {
			JradUser user = jradUserRepository.findById(id).get();
			user.setFirstName(FirstName);
			jradUserRepository.save(user);
			return true;
		} else {
			return false;
		}
	}

	public boolean updateLastNameById(int id, String LastName) {

		if (jradUserRepository.existsById(id)) {
			JradUser user = jradUserRepository.findById(id).get();
			user.setLastName(LastName);
			jradUserRepository.save(user);
			return true;
		} else {
			return false;
		}
	}

	public boolean updateRoleById(int id, Role role) {

		if (jradUserRepository.existsById(id)) {
			JradUser user = jradUserRepository.findById(id).get();
			user.setRole(role);
			jradUserRepository.save(user);
			return true;
		} else {
			return false;
		}
	}

	// Delete
	public boolean deleteById(int id) {

		if (jradUserRepository.existsById(id)) {
			jradUserRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(JradUser user) {
		if (jradUserRepository.existsById(user.getId())) {
			jradUserRepository.delete(user);
			return true;
		} else {
			return false;
		}
	}
}
