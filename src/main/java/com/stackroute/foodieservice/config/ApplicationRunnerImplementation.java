package com.stackroute.foodieservice.config;

import com.stackroute.foodieservice.domain.Restaurant;
import com.stackroute.foodieservice.exceptions.RestaurantAlreadyExists;
import com.stackroute.foodieservice.repository.UserRepository;
import com.stackroute.foodieservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnerImplementation implements ApplicationListener<ContextRefreshedEvent> {


    @Value("${Rid}")
    int id;
    @Value("${Rname}")
    String name;
    @Value("${imageUrl}")
    String image;
    @Value("${Raddress}")
    String address;

    @Autowired
    private UserRepository userRepository;

    public ApplicationRunnerImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Application is running");
//        userRepository.save(new Restaurant(id, name, image, address));


    }
}

