package com.brown;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import com.brown.model.User;
import com.brown.service.UserService;
import com.brown.service.UserServiceImpl;

@SpringBootTest
public class UserServiceImplTest {
    
    @ParameterizedTest
    @ValueSource(strings = {"John"})
    void checkUsername (String name) {
        UserService userService = new UserServiceImpl();
        // given
        User user = new User();
        user.setFirstname("John");
        user.setLastname("Smith");
        user.setEmail("john@gmail.com");
        user.setPassword("password");
        userService.addUser(user);
        // expect
        User john = userService.getUserById(user.getId());
        
        assertTrue(john.getFirstname() == name);
    }
    
    @Test
    void getAllUsersTest (User existingUser) {
        UserService userService = new UserServiceImpl();
        assertTrue(userService.getAllUsers().size() == 0);
    }

}
