package com.witbooking.bidserver.servervices.impl;

import com.witbooking.bidserver.entities.User;
import com.witbooking.bidserver.exceptions.ObjectNotFoundException;
import com.witbooking.bidserver.respositories.IUserRepository;
import com.witbooking.bidserver.servervices.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public String getSessionKey(int id) {
        User user= userRepository.findById(id);
        if (user ==null){
            throw new ObjectNotFoundException("object_not_found", "There is not an user with id " + id);
        }else {
            return user.getSessionKey();
        }
    }

    @Override
    public int getUserIdBySessionKey(String sessionKey) {
        User user= userRepository.findIdBySessionKey(sessionKey);
        if (user==null){
            throw new ObjectNotFoundException("object_not_found", "The sessionKey " + sessionKey + " is not assigned for a user.");
        }else {
            return user.getId();
        }
    }

}
