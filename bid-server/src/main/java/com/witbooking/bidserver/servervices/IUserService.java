package com.witbooking.bidserver.servervices;

import com.witbooking.bidserver.dtos.UserResponseDTO;
import com.witbooking.bidserver.entities.User;

public interface IUserService {
    UserResponseDTO validateSessionKey(User user);
    String getSessionKey (int id);
    int getUserIdBySessionKey (String sessionKey);
}
