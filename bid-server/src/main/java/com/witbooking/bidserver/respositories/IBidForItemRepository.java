package com.witbooking.bidserver.respositories;

import com.witbooking.bidserver.entities.BidForItem;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBidForItemRepository extends MongoRepository<BidForItem, Integer> {
}
