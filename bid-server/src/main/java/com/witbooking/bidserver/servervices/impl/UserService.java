package com.witbooking.bidserver.servervices.impl;

import com.witbooking.bidserver.dtos.UserResponseDTO;
import com.witbooking.bidserver.entities.User;
import com.witbooking.bidserver.respositories.IUserRepository;
import com.witbooking.bidserver.servervices.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Calendar;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;


    @Override
    public String getSessionKey(int id) {
        return userRepository.findById(id).getSessionKey();
    }

    @Override
    public int getUserIdBySessionKey(String sessionKey) {
        return userRepository.findIdBySessionKey(sessionKey).getId();
    }

    public boolean validateSessionKey(long expiredTime) {
        boolean isValidateSessionKey = false;
        Instant instantTime = Instant.now();
        if (expiredTime > instantTime.getEpochSecond()) {
            isValidateSessionKey = true;
        }
        return isValidateSessionKey;
    }

    public long getExpiredTimeByUserId(int userId) {
        Calendar calendar = Calendar.getInstance();
        //TODO: Recuperar de la base
        return calendar.getTimeInMillis();
    }

    public UserResponseDTO validateSessionKey(User user) {
        UserResponseDTO userResponse = new UserResponseDTO();
        long expiredTimeForUser = getExpiredTimeByUserId(user.getId());
        boolean isActiveSession = validateSessionKey(expiredTimeForUser);
        userResponse.setActiveSession(isActiveSession);
        return userResponse;
    }

}
