package com.project2.controller;

import java.sql.Timestamp;
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
import com.project2.model.Role;
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
		System.out.println("Incoming user password: " + user.getPassword());
		String password = DigestUtils.sha256Hex(user.getPassword());
		System.out.println("Incoming user password after hashing: " + password);
		user = jus.findUserByUsername(user.getUsername());
		System.out.println("Password field from database: " + user.getPassword());
		if (user.getPassword().equals(password)) {
			session.setAttribute("user", user);
			return user;
		} else {
			JradUser invalidUser = new JradUser(0, "invalid", "invalid", "invalid", "invalid", "invalid", new Timestamp(System.currentTimeMillis()), new Role(0, "invalid"));
			return invalidUser;
		}
	}
	
	@GetMapping("/logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}

}
