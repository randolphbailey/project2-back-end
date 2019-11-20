package com.project2.tests.repositorytests;

import static org.junit.Assert.*;

import com.project2.repository.JradUserRepository;

// import org.junit.After;
// import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class JradUserRepositoryTest {

    @Autowired
    private JradUserRepository jur;

    @Test
    public void testfindByUsername(){
        assertEquals("test", jur.findByUsername("test").getEmail());
        assertEquals("Test", jur.findByUsername("test").getFirstName());
        assertEquals("test", jur.findByUsername("test").getLastName());
    }

}