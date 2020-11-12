package com.example.FoodFighter.interfaces;

import com.example.FoodFighter.domain.Restaurant;
import com.example.FoodFighter.domain.RestaurantRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

  private RestaurantRepository restaurantRepository = new RestaurantRepository();

  @GetMapping("/restaurant")
  public List<Restaurant> list() {
    return restaurantRepository.findAll();
  }

  @GetMapping("/restaurant/{id}")
  public Restaurant detail(@PathVariable("id") Long id) {
    return restaurantRepository.findById(id);
  }
}
