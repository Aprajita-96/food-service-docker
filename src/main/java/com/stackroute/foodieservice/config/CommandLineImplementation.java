package com.stackroute.foodieservice.config;

import com.stackroute.foodieservice.domain.Restaurant;
import com.stackroute.foodieservice.repository.UserRepository;
import com.stackroute.foodieservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class CommandLineImplementation implements CommandLineRunner {
    @Value("${Rid2}")
    int id;
    @Value(value="${Rname2}")
    String name;
    @Value("${imageUrl2}")
    String image;
    @Value("${Raddress2}")
    String address;

    private RestaurantService repo;
    @Autowired
    public CommandLineImplementation(RestaurantService repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("**************************Command Line Runner is here******************");
        //repo.save1(new Restaurant(id,name,image,address));
    }
}
