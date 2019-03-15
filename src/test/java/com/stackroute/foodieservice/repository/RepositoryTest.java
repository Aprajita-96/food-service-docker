package com.stackroute.foodieservice.repository;

import com.stackroute.foodieservice.domain.Restaurant;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
//when can also write springBootTest..i.e @SpringBootTest
@DataMongoTest

public class RepositoryTest {
    @Autowired
    private UserRepository userRepository;
    private Restaurant restaurant;

    @Before
    public void SetUp(){
        restaurant= new Restaurant();
        restaurant.setId(24);
        restaurant.setRestaurantName("Paradise");
        restaurant.setImageUrl("abc");
        restaurant.setResAddress("Hyderabad");
    }
    @After
    public void tearDown(){
        userRepository.deleteAll();
    }
    @Test
    public void testSave(){
        userRepository.save(restaurant);
        Restaurant fetchedRestaurant=userRepository.findById(restaurant.getId()).get();
        Assert.assertEquals(24,fetchedRestaurant.getId());
    }

    @Test
    public void testGetAll(){
        Restaurant restaurant=new Restaurant(45,"truffles","bcd","banglore");
        Restaurant restaurant1=new Restaurant(34,"Paradiseeee","bbb","Hyderabad");
        userRepository.save(restaurant);
        userRepository.save(restaurant1);
        List<Restaurant> list=userRepository.findAll();
        Assert.assertEquals("truffles",list.get(0).getRestaurantName());
    }
}
