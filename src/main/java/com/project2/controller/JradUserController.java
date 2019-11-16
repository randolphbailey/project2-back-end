package com.project2.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.model.JradUser;
import com.project2.service.JradUserService;

@RestController
@CrossOrigin
@RequestMapping("/jradUser")
public class JradUserController {

	@Autowired
	private JradUserService jus;

	@PostMapping("/create")
	public JradUser create(@RequestBody JradUser user) {
		return jus.create(user);
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
	public void edit(@RequestBody JradUser user) {
		jus.create(user);
	}

	@PostMapping("/delete")
	public void delete(@RequestBody JradUser user) {
		jus.delete(user);
	}

	@PostMapping("/login")
	public JradUser login(@RequestBody JradUser user, HttpSession session) {
		String password = DigestUtils.sha256Hex(user.getPassword());
		user = jus.findUserByUsername(user.getUsername());
		if (user.getPassword() == password) {
			session.setAttribute("user", user);
			return user;
		} else {
			return null;
		}
	}
	
	@GetMapping("/logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}

}
