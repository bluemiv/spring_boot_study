package com.example.FoodFighter.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

  private List<Restaurant> restaurants = new ArrayList<>();

  public RestaurantRepositoryImpl() {
    restaurants.add(new Restaurant(1004L, "My Food House", "Seoul"));
    restaurants.add(new Restaurant(2020L, "Food Fighter", "Seoul"));
  }

  @Override
  public List<Restaurant> findAll() {
    return restaurants;
  }

  @Override
  public Restaurant findById(Long id) {
    return restaurants.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
  }
}
