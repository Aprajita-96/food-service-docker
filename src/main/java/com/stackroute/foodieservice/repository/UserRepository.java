package com.stackroute.foodieservice.repository;

import com.mongodb.Mongo;
import com.stackroute.foodieservice.domain.Restaurant;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Restaurant,Integer> {

////    @Query(value = "SELECT r FROM Restaurant r WHERE r.restaurantName=?1")
      Restaurant findByRestaurantName(String name);
}
