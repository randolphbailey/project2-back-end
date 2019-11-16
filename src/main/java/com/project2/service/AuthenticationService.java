package com.project2.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.model.JradUser;

@Service
public class AuthenticationService {
	
	@Autowired
	private JradUserService jus;
	
	public boolean isAdministrator(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return false;
		}
		JradUser user = (JradUser) session.getAttribute("user");
		if (user.getRole().getRole() != "Administrator") {
			return false;
		}
		return true;
	}
	
	public boolean isModerator(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return false;
		}
		JradUser user = (JradUser) session.getAttribute("user");
		if (user.getRole().getRole() != "Moderator") {
			return false;
		}
		return true;
	}
	
	public boolean isUser(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return false;
		}
		JradUser user = (JradUser) session.getAttribute("user");
		if (user.getRole().getRole() != "User") {
			return false;
		}
		return true;
	}
	
	public boolean userExists(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return false;
		}
		return true;
	}
}
