package com.stackroute.foodieservice.service;

import com.stackroute.foodieservice.domain.Restaurant;
import com.stackroute.foodieservice.exceptions.RestaurantAlreadyExists;
import com.stackroute.foodieservice.exceptions.RestaurantNotFound;
import com.stackroute.foodieservice.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Null;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ServiceTest {
    private Restaurant restaurant;


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RestaurantService restaurantService;
    List<Restaurant> list=null;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        restaurant=new Restaurant();
        restaurant.setId(24);
        restaurant.setRestaurantName("Paradise");
        restaurant.setImageUrl("abc");
        restaurant.setResAddress("Hyderabad");
        list= new ArrayList<>();
        list.add(restaurant);
    }


    @Test
    public void save() throws RestaurantAlreadyExists{

        when(userRepository.save((Restaurant)any())).thenReturn(restaurant);
        Restaurant restaurant1=restaurantService.save1(restaurant);
        Assert.assertEquals(restaurant,restaurant1);
    }

    @Test(expected=RestaurantAlreadyExists.class)
    public void saveFailure() throws RestaurantAlreadyExists{
        Mockito.when(userRepository.save((Restaurant)any())).thenReturn(null);
        Restaurant savedRestaurant= restaurantService.save1(restaurant);
    System.out.println(savedRestaurant);

        Assert.assertEquals(restaurant,savedRestaurant);
}

@Test
    public void getAll(){
        userRepository.save(restaurant);
        when(userRepository.findAll()).thenReturn(list);
        List<Restaurant> restaurantList=restaurantService.getAllRestaurant();
        Assert.assertEquals(list,restaurantList);
}
}



