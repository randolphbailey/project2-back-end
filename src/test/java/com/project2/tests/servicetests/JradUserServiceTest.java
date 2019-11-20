package com.project2.tests.servicetests;

import static org.junit.Assert.*;

import com.project2.service.JradUserService;

// import org.junit.After;
// import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class JradUserServiceTest {

    @Autowired
    JradUserService jus;

    @Test
    public void testfindUserById(){
        assertEquals("test", jus.findUserById(1).get().getEmail());
        assertEquals("Test", jus.findUserById(1).get().getFirstName());
        assertEquals("test", jus.findUserById(1).get().getLastName());
    }

    @Test
    public void testfindUserByUsername(){
        assertEquals("test", jus.findUserByUsername("test").getEmail());
        assertEquals("Test", jus.findUserByUsername("test").getFirstName());
        assertEquals("test", jus.findUserByUsername("test").getLastName());
    }

    @Test
    public void testfindIdByUsername(){
        assertEquals(1, jus.findIdByUsername("test"));
    }
}