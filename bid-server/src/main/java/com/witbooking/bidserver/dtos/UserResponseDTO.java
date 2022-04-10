package com.witbooking.bidserver.dtos;

import java.sql.Timestamp;

public class UserResponseDTO {
    private String sessionKey;
    private Timestamp expiredTimeSessionKey;
    private boolean activeSession;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public Timestamp getExpiredTimeSessionKey() {
        return expiredTimeSessionKey;
    }

    public void setExpiredTimeSessionKey(Timestamp expiredTimeSessionKey) {
        this.expiredTimeSessionKey = expiredTimeSessionKey;
    }

    public boolean isActiveSession() {
        return activeSession;
    }

    public void setActiveSession(boolean activeSession) {
        this.activeSession = activeSession;
    }
}
