package com.stackroute.foodieservice.exceptions;

public class RestaurantNotFound extends Exception {
    private String message;
    public RestaurantNotFound(){}
    public RestaurantNotFound(String message){
        super(message);
        this.message=message;
    }
}
