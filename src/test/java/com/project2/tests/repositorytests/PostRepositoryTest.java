package com.project2.tests.repositorytests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import com.project2.model.JradUser;
import com.project2.model.Post;
import com.project2.model.Status;
import com.project2.repository.JradUserRepository;
import com.project2.repository.PostRepository;

// import org.junit.After;
// import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PostRepositoryTest {

    @Autowired
    private PostRepository pr;

    @Autowired
    private JradUserRepository jur;

    @Test
    public void testfindByStatus(){

        Status teststaus = new Status(6, "Test");

        Optional<Post> posttest = pr.findById(1);
        List<Post> postarr = pr.findByStatus(teststaus);

        assertEquals(posttest.get(), postarr.get(0));
    }

    //List<Post> findByjradUser(JradUser jradUser);

    @Test
    public void testfindByjradUser(){

        JradUser jradUser = jur.findById(1).get();

        //Comparison happens between the test user and the method
        assertEquals(pr.findById(1).get(), pr.findByjradUser(jradUser).get(1));
    }

}