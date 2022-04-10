package com.witbooking.bidserver.respositories;

import com.witbooking.bidserver.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends MongoRepository<User, Integer> {
    User findById(int id);
    User findIdBySessionKey(String sessionKey);
}
