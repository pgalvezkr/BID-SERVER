package com.witbooking.bidserver.servervices;

import com.witbooking.bidserver.dtos.UserResponseDTO;
import com.witbooking.bidserver.entities.User;

import java.time.Instant;

public interface IUserService {
    String getSessionKey (int id);
    int getUserIdBySessionKey (String sessionKey);
}
