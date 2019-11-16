package com.project2.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.model.JradUser;
import com.project2.model.Role;
import com.project2.model.Status;
import com.project2.service.RoleService;
import com.project2.service.StatusService;

@RestController
@CrossOrigin
@RequestMapping("/testing")
public class TestController {
	
	@Autowired
	private StatusService ss;
	
	@Autowired
	private RoleService rs;
	
	@GetMapping("/insertrolesandstatuses")
	public void test() {
		Status approved = new Status(0, "Approved");
		Status denied = new Status(0, "Denied");
		Status banned = new Status(0, "Banned");
		
		Role regularUser = new Role(0, "User");
		Role moderator = new Role(0, "Moderator");
		Role admin = new Role(0, "Administrator");
		
		ss.newStatus(approved);
		ss.newStatus(denied);
		ss.newStatus(banned);
		
		rs.create(admin);
		rs.create(moderator);
		rs.create(regularUser);
	}
	
	@GetMapping("/readusersession")
	public JradUser userSession(HttpSession session) {
		System.out.println(session.getAttribute("user"));
		return (JradUser) session.getAttribute("user");
	}
	
	@PostMapping("/createusersession")
	public JradUser setSession(HttpSession session) {
		Role userRole = rs.findByRole("Administrator");
		JradUser testUser = new JradUser(1, "test", "test", "test", "test", "test", new Timestamp(System.currentTimeMillis()), userRole);
		session.setAttribute("user", testUser);
		return testUser;
	}
	
}
