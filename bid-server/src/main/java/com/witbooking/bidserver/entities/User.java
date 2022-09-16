package com.witbooking.bidserver.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document("user")
public class User {

    @Id
    private int id;
    private Instant expiredTimeSessionKey;
    private String sessionKey;

    public User() {
    }

    public User(int id, Instant expiredTimeSessionKey, String sessionKey) {
        this.id = id;
        this.expiredTimeSessionKey = expiredTimeSessionKey;
        this.sessionKey = sessionKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getExpiredTimeSessionKey() {
        return expiredTimeSessionKey;
    }

    public void setExpiredTimeSessionKey(Instant expiredTimeSessionKey) {
        this.expiredTimeSessionKey = expiredTimeSessionKey;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
