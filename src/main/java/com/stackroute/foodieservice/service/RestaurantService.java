package com.stackroute.foodieservice.service;

import com.stackroute.foodieservice.domain.Restaurant;
import com.stackroute.foodieservice.exceptions.RestaurantAlreadyExists;
import com.stackroute.foodieservice.exceptions.RestaurantNotFound;
import com.stackroute.foodieservice.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    private UserRepository userRepository;

    @Autowired
       public RestaurantService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Restaurant save1(Restaurant restaurant) throws RestaurantAlreadyExists  {
        if(userRepository.existsById(restaurant.getId())){
            throw new RestaurantAlreadyExists("user already exists");
        }
          Restaurant resultant=userRepository.save(restaurant);
        if(resultant==null){
            throw new RestaurantAlreadyExists("user null");
        }

        return resultant;
    }


    public void delete(Restaurant restaurant){
        userRepository.delete(restaurant);
    }


    public List<Restaurant> getAllRestaurant(){
        List<Restaurant> resultant=userRepository.findAll();
        return resultant;
    }


    public Restaurant getById(int id) throws RestaurantNotFound {
        Optional<Restaurant> result;
        if(!userRepository.existsById(id)){
            throw new RestaurantNotFound("user not found");
        }
            result = userRepository.findById(id);

         return result.get();
    }
    public Restaurant updateRestaurant(Restaurant restaurant , int id){
        Optional<Restaurant> result=userRepository.findById(id);
        Restaurant fetchedRestaurant=result.get();
        fetchedRestaurant.setImageUrl(restaurant.getImageUrl());
        fetchedRestaurant.setResAddress(restaurant.getResAddress());
        fetchedRestaurant.setRestaurantName(restaurant.getRestaurantName());
        return userRepository.save(fetchedRestaurant);
    }
    public Restaurant findByName(String name) {
//        Restaurant result=new Restaurant();
//        List<Restaurant> list=(List<Restaurant>)userRepository.findAll();
//        for(Restaurant restaurant:list){
//            System.out.println(restaurant.getRestaurantName());
//            System.out.println(name);
//             if((restaurant.getRestaurantName()).equals(name)){
//                 result.setRestaurantName(restaurant.getRestaurantName());
//                 result.setResAddress(restaurant.getResAddress());
//                 result.setId(restaurant.getId());
//
//             }
//         }
//      return result;
//    }
        Restaurant restaurant = userRepository.findByRestaurantName(name);
        return restaurant;
    }


}
