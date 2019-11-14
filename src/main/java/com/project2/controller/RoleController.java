package com.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.service.RoleService;

@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService rs;
}
