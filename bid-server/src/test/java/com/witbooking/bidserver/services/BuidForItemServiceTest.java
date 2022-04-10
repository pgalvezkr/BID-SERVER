package com.witbooking.bidserver.services;

import com.witbooking.bidserver.entities.BidByItem;
import com.witbooking.bidserver.entities.BidForItem;
import com.witbooking.bidserver.entities.User;
import com.witbooking.bidserver.exceptions.ObjectNotFoundException;
import com.witbooking.bidserver.respositories.IBidForItemRepository;
import com.witbooking.bidserver.respositories.IUserRepository;
import com.witbooking.bidserver.servervices.impl.BidForItemService;
import com.witbooking.bidserver.servervices.impl.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BuidForItemServiceTest {

    private User testUser;

    @Mock
    private IBidForItemRepository bidForItemRepository;

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private BidForItemService bidForItemService = new BidForItemService();


    @BeforeEach
    void setMockOutput() {
        testUser = new User();
        testUser.setId(123);
        testUser.setSessionKey("KSIC");
        testUser.setExpiredTimeSessionKey(Instant.now());
    }

    @DisplayName("Test save bid for item by user when user exists")
    @Test
    void saveBidForItemByUserWhenUserExistsTest (){
        Mockito.when(userRepository.findIdBySessionKey(Mockito.anyString())).thenReturn(testUser);
        BidForItem bidForItem = new BidForItem();
        bidForItem.setItemId(1);
        bidForItem.setUserId(testUser.getId());
        bidForItem.setBid(12.5);
        Assertions.assertDoesNotThrow(()->{
            bidForItemService.saveBidForItemByUser(bidForItem, testUser.getSessionKey());
        });
    }

    @DisplayName("Test save bid for item by user when user not exists")
    @Test
    void saveBidForItemByUserWhenUserNotExistsTest (){
        Mockito.when(userRepository.findIdBySessionKey(Mockito.anyString())).thenReturn(null);
        BidForItem bidForItem = new BidForItem();
        bidForItem.setItemId(1);
        bidForItem.setUserId(testUser.getId());
        bidForItem.setBid(12.5);
        Assertions.assertThrows(ObjectNotFoundException.class, ()->{
            bidForItemService.saveBidForItemByUser(bidForItem, testUser.getSessionKey());
        });
    }
}
