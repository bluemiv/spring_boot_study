package com.example.FoodFighter.interfaces;

import com.example.FoodFighter.application.RestaurantService;
import com.example.FoodFighter.domain.MenuItem;
import com.example.FoodFighter.domain.Restaurant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestaurantController.class)
class RestaurantControllerTests {

  @Autowired private MockMvc mvc;

  @MockBean private RestaurantService restaurantService;

  @Test
  public void list() throws Exception {
    List<Restaurant> restaurants = new ArrayList<>();
    restaurants.add(new Restaurant(1004L, "My Food House", "Seoul"));
    given(restaurantService.getRestaurants()).willReturn(restaurants);

    mvc.perform(get("/restaurant"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"name\":\"My Food House\"")))
        .andExpect(content().string(containsString("\"id\":1004")));
  }

  @Test
  public void detail() throws Exception {
    Restaurant restaurant = new Restaurant(1004L, "My Food House", "Seoul");
    restaurant.addMenuItem(new MenuItem("Pizza"));
    given(restaurantService.getRestaurant(1004L)).willReturn(restaurant);

    Restaurant restaurant2 = new Restaurant(2020L, "Food Fighter", "Seoul");
    restaurant2.addMenuItem(new MenuItem("Pizza"));
    given(restaurantService.getRestaurant(2020L)).willReturn(restaurant2);

    mvc.perform(get("/restaurant/1004"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"name\":\"My Food House\"")))
        .andExpect(content().string(containsString("\"id\":1004")))
        .andExpect(content().string(containsString("Pizza")));

    mvc.perform(get("/restaurant/2020"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"name\":\"Food Fighter\"")))
        .andExpect(content().string(containsString("\"id\":2020")));
  }
}
