package com.witbooking.bidserver.servervices.impl;

import com.witbooking.bidserver.dtos.UserResponseDTO;
import com.witbooking.bidserver.entities.User;
import com.witbooking.bidserver.exceptions.ObjectNotFoundException;
import com.witbooking.bidserver.respositories.IUserRepository;
import com.witbooking.bidserver.servervices.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

    @Override
    public UserResponseDTO createUsers() {
        List <User> users = new ArrayList<>();
        User inactiveUser = new User(4, Instant.now(), generateSessionKey());
        for (int i =1; i <=3; ++i){
            User newUser = new User(i, Instant.now().plusSeconds(600), generateSessionKey());
            users.add(newUser);
        }
        users.add(inactiveUser);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUsers(userRepository.saveAll(users));
        return  userResponseDTO;
    }

    private String generateSessionKey() {
        String possibleCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sessionKey = new StringBuilder();
        for (int i = 0; i < 7; ++i) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, possibleCharacters.length());
            sessionKey.append(possibleCharacters.charAt(randomIndex));
        }
        return sessionKey.toString().trim();
    }
}
