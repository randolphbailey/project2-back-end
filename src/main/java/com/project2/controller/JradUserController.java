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

	@GetMapping("/create/{comment}")
	public void userCreation(@PathVariable JradUser user){
		jus.create(user);
	}

	@GetMapping("/all")
	public List<JradUser> getAllUser() {
		return jus.findAll();
	}

	@GetMapping("/retrieveuser/{id}")
	public Optional<JradUser> getUserById(@PathVariable int id) {
		return jus.findUserById(id);
	}

	@GetMapping("/retrieveusername/{user}")
	public JradUser getUserByUsername(@PathVariable String user) {
		return jus.findUserByUsername(user);
	}

	@PostMapping("/editpassword/{password}{id}")
	public void updatePassword(@RequestBody int id, String password){
		jus.updatePasswordById(id, password);
	}

	@PostMapping("/editfirstname/{first}{id}")
	public void updateFirstName(@RequestBody int id, String firstName){
		jus.updateFirstNameById(id, firstName);
	}

	@PostMapping("/editlastname/{last}{id}")
	public void updateLastName(@RequestBody int id, String lastName){
		jus.updateLastNameById(id, lastName);
	}

	@PostMapping("/editrole/{role}{id}")
	public void updateRole(@RequestBody int id, Role role){
		jus.updateRoleById(id, role);
	}

	@PostMapping("/delete/{id}")
	public void delete(@RequestBody int id){
		jus.deleteById(id);
	}




	

}
