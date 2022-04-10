package com.witbooking.bidserver.services;


import com.witbooking.bidserver.entities.User;
import com.witbooking.bidserver.exceptions.ObjectNotFoundException;
import com.witbooking.bidserver.respositories.IUserRepository;
import com.witbooking.bidserver.servervices.impl.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

@SpringBootTest
public class UserServiceTest {

    private User testUser;

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService = new UserService();

    @BeforeEach
    void setMockOutput() {
        testUser = new User();
        testUser.setId(123);
        testUser.setSessionKey("KSIC");
        testUser.setExpiredTimeSessionKey(Instant.now());
    }

    @DisplayName("Test get session key for user id that exists")
    @Test
    void getSessionKeyByUserIdExistsTest() {
        Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(testUser);
        String sessionKey = userService.getSessionKey(123);
        Assertions.assertEquals("KSIC", sessionKey);
    }

    @DisplayName("Test get session key for user id that not exists")
    @Test
    void getSessionKeyByUserIdNotExistsTest() {
        Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(null);
        Assertions.assertThrows(ObjectNotFoundException.class, () -> {
            userService.getSessionKey(123);
        });
    }

    @DisplayName("Test get user by id when user exists")
    @Test
    void getUserIdBySessionKeyWhenExistisTest() {
        Mockito.when(userRepository.findIdBySessionKey(Mockito.anyString())).thenReturn(testUser);
        int userId = userService.getUserIdBySessionKey("KSIC");
        Assertions.assertEquals(123, userId);
    }

    @DisplayName("Test get user by id when user not exists")
    @Test
    void getUserIdBySessionKeyWhenNotExistisTest() {
        Mockito.when(userRepository.findIdBySessionKey(Mockito.anyString())).thenReturn(null);
        Assertions.assertThrows(ObjectNotFoundException.class, () -> {
            userService.getUserIdBySessionKey("KSIC");
        });
    }
}
