package com.witbooking.bidserver.servervices;

import com.witbooking.bidserver.dtos.UserResponseDTO;

public interface IUserService {
    String getSessionKey (int id);
    int getUserIdBySessionKey (String sessionKey);
    UserResponseDTO createUsers ();
}
