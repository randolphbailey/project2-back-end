package com.project2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.project2.service.RoleService;

public class RoleTest {
	
	RoleService rs = null;

	@Before
	public void setUp() throws Exception {
		rs = new RoleService();
	}

	@After
	public void tearDown() throws Exception {
		rs = null;
	}

	@Test
	public void findByRole() {
		assertEquals("Administrator", rs.findByRole("Administrator").getRole());
		assertEquals("User", rs.findByRole("User").getRole());
		assertEquals("Moderator", rs.findByRole("Moderator"));
	}
	
	@Test
	public void findById() {
		assertEquals("Administrator", rs.findById(1).get().getRole());
		assertEquals("Moderator", rs.findById(2).get().getRole());
		assertEquals("User", rs.findById(3).get().getRole());
	}

}
