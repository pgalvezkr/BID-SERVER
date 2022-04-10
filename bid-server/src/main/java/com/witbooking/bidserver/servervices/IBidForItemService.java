package com.witbooking.bidserver.servervices;

import com.witbooking.bidserver.entities.BidByItem;
import com.witbooking.bidserver.entities.BidForItem;

import java.util.List;

public interface IBidForItemService {
    void saveBidForItemByUser(BidForItem bidForItem, String sessionKey);
    List<BidByItem> getAllBidForItemsByUserIdAndItemId(int articleId);
}
