package com.stackroute.foodieservice.controller;

import com.stackroute.foodieservice.domain.Restaurant;
import com.stackroute.foodieservice.exceptions.RestaurantAlreadyExists;
import com.stackroute.foodieservice.exceptions.RestaurantNotFound;
import com.stackroute.foodieservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestaurantController {
    private RestaurantService restaurantService;
    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("restaurant")
    public ResponseEntity<Restaurant> save12(@RequestBody Restaurant restaurant) throws RestaurantAlreadyExists{
        ResponseEntity responseEntity;
            Restaurant result = restaurantService.save1(restaurant);
            responseEntity=new ResponseEntity<Restaurant>(result,HttpStatus.CREATED);

        return responseEntity;
    }


    @DeleteMapping("restaurants")
    public void delete(@RequestBody Restaurant restaurant){
        restaurantService.delete(restaurant);
    }


    @GetMapping("restaurants")
    public ResponseEntity<?>getAll(){
        List<Restaurant> list=restaurantService.getAllRestaurant();

        return new ResponseEntity<List<Restaurant>>(list, HttpStatus.OK);
    }


    @GetMapping("restaurant/{id}")
    public ResponseEntity<Restaurant> getById(@PathVariable("id") int id) throws RestaurantNotFound{
        ResponseEntity responseEntity;

            Restaurant restaurant = restaurantService.getById(id);
            responseEntity=new ResponseEntity<Restaurant>(restaurant,HttpStatus.FOUND);

       return  responseEntity;
    }


    @PutMapping("restaurant/{id}")
    public ResponseEntity<Restaurant> update(@RequestBody Restaurant restaurant,@PathVariable("id") int id){
        Restaurant restaurant1=restaurantService.updateRestaurant(restaurant,id);
        return new ResponseEntity<Restaurant>(restaurant1,HttpStatus.OK);
    }


    @GetMapping("restaurants/{name}")
    public ResponseEntity<Restaurant> find(@PathVariable("name") String name){
        Restaurant restaurant=restaurantService.findByName(name);
        return new ResponseEntity<Restaurant>(restaurant,HttpStatus.FOUND);

    }
}
