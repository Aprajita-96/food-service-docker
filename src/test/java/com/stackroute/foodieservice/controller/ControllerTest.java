package com.stackroute.foodieservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.foodieservice.domain.Restaurant;
import com.stackroute.foodieservice.service.RestaurantService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private Restaurant restaurant;
    @MockBean
    private RestaurantService restaurantService;
    @InjectMocks
    private RestaurantController restaurantController;
    List<Restaurant> list;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(restaurantController).build();
        restaurant=new Restaurant();
        restaurant.setId(24);
        restaurant.setRestaurantName("Paradise");
        restaurant.setImageUrl("abc");
        restaurant.setResAddress("Hyderabad");
        list=new ArrayList();
        list.add(restaurant);


    }
    @Test
    public void save() throws Exception{
        when(restaurantService.save1((Restaurant)any())).thenReturn(restaurant);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/restaurant")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(restaurant)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void getAll() throws Exception{
        when(restaurantService.getAllRestaurant()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/restaurants")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(restaurant)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());


    }



    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
