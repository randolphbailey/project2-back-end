package com.project2.tests.servicetests;

import static org.junit.Assert.*;

import com.project2.model.JradUser;
import com.project2.repository.PostRepository;
import com.project2.service.JradUserService;
import com.project2.service.PostService;

// import org.junit.After;
// import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PostServiceTest {

    @Autowired
    PostService ps;

    @Autowired
    PostRepository pr;

    @Autowired
    JradUserService jus;

    @Test
    public void testfindByUser() {

        JradUser testuser = jus.findUserById(1).get();
        
        ps.findByUser(testuser);

        //compares the first post with the first post of the test user
        assertEquals(pr.findById(1).get(), ps.findByUser(testuser).get(1));
    }
    
    @Test
    public void testfindAll(){

        //compares the first post with the first post of all returned
        assertEquals(pr.findById(1).get(), ps.findAll().get(1));
    }
	
}