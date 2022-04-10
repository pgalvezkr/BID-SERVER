package com.witbooking.bidserver.controllers;

import com.witbooking.bidserver.servervices.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping ("/{id}/login")
    public String getSessionKey (@PathVariable("id") int id){
        return userService.getSessionKey(id);
    }

}
