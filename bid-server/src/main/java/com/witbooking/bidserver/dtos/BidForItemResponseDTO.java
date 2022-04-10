package com.witbooking.bidserver.dtos;

public class BidForItemResponseDTO {
    private int userId;
    private double bid;

    public BidForItemResponseDTO(int userId, double bid) {
        this.userId = userId;
        this.bid = bid;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }
}
