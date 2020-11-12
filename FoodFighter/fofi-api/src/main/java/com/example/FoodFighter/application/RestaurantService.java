package com.example.FoodFighter.application;

import com.example.FoodFighter.domain.MenuItemRepository;
import com.example.FoodFighter.domain.Restaurant;
import com.example.FoodFighter.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

  private final RestaurantRepository restaurantRepository;
  private final MenuItemRepository menuItemRepository;

  @Autowired
  public RestaurantService(
      RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
    this.restaurantRepository = restaurantRepository;
    this.menuItemRepository = menuItemRepository;
  }

  public List<Restaurant> getRestaurants() {
    return restaurantRepository.findAll();
  }

  public Restaurant getRestaurant(Long id) {
    Restaurant restaurant = restaurantRepository.findById(id);
    restaurant.setMenuItems(menuItemRepository.findAllByRestaurantId(id));

    return restaurant;
  }
}
