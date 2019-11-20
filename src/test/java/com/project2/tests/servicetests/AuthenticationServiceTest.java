package com.project2.tests.servicetests;

// import static org.junit.Assert.*;

// import java.util.List;
// import java.util.Optional;

// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpSession;

// import com.project2.model.JradUser;
// import com.project2.model.Post;
// import com.project2.model.Status;
// import com.project2.repository.JradUserRepository;
// import com.project2.repository.PostRepository;
// import com.project2.service.AuthenticationService;

// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.mock.web.MockHttpServletRequest;
// import org.springframework.mock.web.MockHttpSession;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.web.context.WebApplicationContext;

// @RunWith(SpringRunner.class)
// @SpringBootTest

//This class is not used for testing this is just here for reference
public class AuthenticationServiceTest {

    

    // @Autowired
    // private AuthenticationService as;

    // @Autowired
    // private JradUserRepository jur;

    // // @Autowired
    // // private FilterChainProxy springSecurityFilterChain;

    // @Autowired
    // protected WebApplicationContext wac;
    
    // protected MockHttpSession usersession;
    // protected MockHttpSession adminsession;
    // protected MockHttpSession moderatesession;
    // protected MockHttpServletRequest request;

    // usersession = request.getSession();
    // usersession.setAttribute("user", user);

    // adminsession = request.getSession();
    // usersession.setAttribute("user", adminuser);

    // moderatesession = request.getSession();
    // usersession.setAttribute("user", moderateuser);

    // //Moderator User
    // JradUser moderateuser = jur.findById(4).get();
    // //Administrator User
    // JradUser adminuser = jur.findById(6).get();
    // //User
    // JradUser user = jur.findById(1).get();

    // @Test
    // public void testisAdministrator(){

    //     //Testing if a user can log in as admin
    //     assertNotEquals(as.isAdministrator(usersession), as.isAdministrator(adminsession));
    //     //Testing if a moderator can logiin as admin
    // }

    // @After
    // public void closing(){
    //     usersession.invalidate();
    //     adminsession.invalidate();
    //     moderatesession.invalidate();
    // }
}