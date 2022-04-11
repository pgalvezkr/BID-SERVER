package com.witbooking.bidserver.dtos;

import com.witbooking.bidserver.entities.User;

import java.sql.Timestamp;
import java.util.List;

public class UserResponseDTO {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
