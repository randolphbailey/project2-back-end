package com.project2.tests.repositorytests;

import static org.junit.Assert.*;

import com.project2.repository.StatusRepository;

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

public class StatusRepositoryTest {
	
    //RoleService rs = null;

    @Autowired
    private StatusRepository sr;

    //Status findByStatus(String status);


    @Test
    public void testfindByStatus(){
        assertEquals(sr.findById(1).get(), sr.findByStatus("Approved"));
        assertEquals(sr.findById(2).get(), sr.findByStatus("Denied"));
        assertEquals(sr.findById(3).get(), sr.findByStatus("Banned"));
        assertEquals(sr.findById(4).get(), sr.findByStatus("Public"));
        assertEquals(sr.findById(5).get(), sr.findByStatus("Private"));
        assertEquals(sr.findById(6).get(), sr.findByStatus("Test"));

    }

}
