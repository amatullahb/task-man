package com.brown;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.brown.model.User;
import com.brown.service.UserService;
import com.brown.service.UserServiceImpl;

@SpringBootTest
public class UserRepositoryTest {
    
    @Test
    void findByEmailTest () {
        User user = new User();
        user.setFirstname("John");
        user.setLastname("Smith");
        user.setEmail("jsmith@gmail.com");
        user.setPassword("password");
        
        UserService userService = new UserServiceImpl();
        User foundUser = userService.findUserByEmail("jsmith@gmail.com");
        
        assertEquals(user, foundUser);
    }

}
