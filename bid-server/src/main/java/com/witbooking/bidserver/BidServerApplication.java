package com.witbooking.bidserver;

import com.witbooking.bidserver.respositories.IUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication (exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@EnableMongoRepositories (basePackages = {"com.witbooking.bidserver.respositories"})
public class BidServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BidServerApplication.class, args);
	}

}
