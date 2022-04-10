package com.witbooking.bidserver.controllers;

import com.witbooking.bidserver.dtos.BidForItemDTO;
import com.witbooking.bidserver.dtos.BidForItemResponseDTO;
import com.witbooking.bidserver.entities.BidByItem;
import com.witbooking.bidserver.entities.BidForItem;
import com.witbooking.bidserver.servervices.IBidForItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidForItemController {

    @Autowired
    private IBidForItemService bidForItemService;

    @PostMapping("/{itemId}/bid")
    public void saveBidForItem(@PathParam("sessionKey") String sessionKey, @PathVariable int itemId, @RequestBody BidForItemDTO body) {
        BidForItem bidForItem = new BidForItem();
        bidForItem.setItemId(itemId);
        bidForItem.setBid(body.getBid());
        bidForItemService.saveBidForItemByUser(bidForItem, sessionKey);
    }

    @GetMapping("/{itemId}/topBidList")
    public List<BidForItemResponseDTO> getBidsForItem(@PathParam("sessionKey") String sessionKey, @PathVariable int itemId) {
        List<BidForItemResponseDTO> topBidList = new ArrayList<>();
        List<BidByItem> resultBidsForItem = bidForItemService.getAllBidForItemsByUserIdAndItemId(itemId);
        for (BidByItem bidForItem : resultBidsForItem) {
            BidForItemResponseDTO bidForItemResponseDTO = new BidForItemResponseDTO(bidForItem.getId(), bidForItem.getBid());
            topBidList.add(bidForItemResponseDTO);
        }
        return topBidList;
    }
}
