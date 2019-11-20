package com.project2.tests.repositorytests;

import static org.junit.Assert.*;

import com.project2.repository.RoleRepository;

// import org.junit.After;
// import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import com.project2.se.RoleService;



@RunWith(SpringRunner.class)
@SpringBootTest

public class RoleRepositoryTest {
	
    //RoleService rs = null;

    @Autowired
    private RoleRepository rr;


    @Test
    public void testfindByRole(){
        assertEquals("Administrator", rr.findByRole("Administrator").getRole());
        assertEquals("Moderator", rr.findByRole("Moderator").getRole());
        assertEquals("User", rr.findByRole("User").getRole());
    }

}