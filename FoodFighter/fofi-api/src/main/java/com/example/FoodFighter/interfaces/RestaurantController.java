package com.example.FoodFighter.interfaces;

import com.example.FoodFighter.application.RestaurantService;
import com.example.FoodFighter.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

  @Autowired private RestaurantService restaurantService;

  @GetMapping("/restaurant")
  public List<Restaurant> list() {
    return restaurantService.getRestaurants();
  }

  @GetMapping("/restaurant/{id}")
  public Restaurant detail(@PathVariable("id") Long id) {
    Restaurant restaurant = restaurantService.getRestaurant(id);
    return restaurant;
  }
}
