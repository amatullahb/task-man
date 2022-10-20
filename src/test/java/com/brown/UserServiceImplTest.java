package com.brown;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.springframework.boot.test.context.SpringBootTest;

import com.brown.model.User;
import com.brown.service.UserService;
import com.brown.service.UserServiceImpl;

@SpringBootTest
public class UserServiceImplTest {
    
//    @BeforeAll
//    UserService userService = new UserServiceImpl();
    User user = new User();
    
    
    @ParameterizedTest
    @EmptySource
    void getAllUsersTest () {
        UserService userService = new UserServiceImpl();
        assertTrue(userService.getAllUsers().size() == 0);
    }

}
