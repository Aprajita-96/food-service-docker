package com.stackroute.foodieservice.exceptions;

public class RestaurantAlreadyExists extends Exception {
    private String message;

    public RestaurantAlreadyExists(){}

    public RestaurantAlreadyExists(String message){
        super(message);
        this.message=message;
    }

}
