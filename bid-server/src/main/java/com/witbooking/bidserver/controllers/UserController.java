package com.witbooking.bidserver.controllers;

import com.witbooking.bidserver.dtos.UserResponseDTO;
import com.witbooking.bidserver.servervices.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping ("/{id}/login")
    public String getSessionKey (@PathVariable("id") int id){
        return userService.getSessionKey(id);
    }

    @PostMapping("/infrastructure")
    public UserResponseDTO createUsers(){
        return  userService.createUsers();
    }
}
