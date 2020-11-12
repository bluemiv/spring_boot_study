package com.example.FoodFighter.domain;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantRepository {

  private List<Restaurant> restaurants = new ArrayList<>();

  public RestaurantRepository() {
    restaurants.add(new Restaurant(1004L, "My Food House", "Seoul"));
    restaurants.add(new Restaurant(2020L, "Food Fighter", "Seoul"));
  }

  public List<Restaurant> findAll() {

    return restaurants;
  }

  public Restaurant findById(Long id) {
    return restaurants.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
  }
}
