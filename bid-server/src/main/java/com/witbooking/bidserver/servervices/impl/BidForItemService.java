package com.witbooking.bidserver.servervices.impl;

import com.witbooking.bidserver.entities.BidByItem;
import com.witbooking.bidserver.entities.BidForItem;
import com.witbooking.bidserver.entities.User;
import com.witbooking.bidserver.exceptions.ObjectNotFoundException;
import com.witbooking.bidserver.respositories.IBidForItemRepository;
import com.witbooking.bidserver.respositories.IUserRepository;
import com.witbooking.bidserver.servervices.IBidForItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BidForItemService implements IBidForItemService {

    @Autowired
    private IBidForItemRepository bidForItemRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveBidForItemByUser(BidForItem bidForItem, String sessionKey) {
        User user = userRepository.findIdBySessionKey(sessionKey);
        if (user ==null){
            throw new ObjectNotFoundException("object_not_found", "The user with sessionKey " + sessionKey + " does not exists. So your bid will not be save.");
        }else{
            bidForItem.setUserId(user.getId());
        }
        bidForItemRepository.save(bidForItem);
    }

    @Override
    public List<BidByItem> getAllBidForItemsByUserIdAndItemId(int itemId) {
        AggregationOperation matchItemId = Aggregation.match(Criteria.where("itemId").is(itemId));
        GroupOperation groupByUserAndMaxBid= Aggregation.group("userId")
                .max("bid").as("bid");
        ExposedFields fields =  groupByUserAndMaxBid.getFields();
        SortOperation sortByBidDesc = Aggregation.sort(Sort.by(Sort.Direction.DESC, "bid"));
        LimitOperation limitToFifteentDocs = Aggregation.limit(15);
        Aggregation aggregation = Aggregation.newAggregation(matchItemId, groupByUserAndMaxBid, sortByBidDesc, limitToFifteentDocs);
        AggregationResults<BidByItem> result = mongoTemplate.aggregate(aggregation, "bid_for_item", BidByItem.class);

        return  result.getMappedResults();
    }
}
