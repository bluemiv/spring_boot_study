package com.example.FoodFighter.interfaces;

import com.example.FoodFighter.domain.MenuItem;
import com.example.FoodFighter.domain.MenuItemRepository;
import com.example.FoodFighter.domain.Restaurant;
import com.example.FoodFighter.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

  @Autowired private RestaurantRepository restaurantRepository;
  @Autowired private MenuItemRepository menuItemRepository;

  @GetMapping("/restaurant")
  public List<Restaurant> list() {
    return restaurantRepository.findAll();
  }

  @GetMapping("/restaurant/{id}")
  public Restaurant detail(@PathVariable("id") Long id) {
    Restaurant restaurant = restaurantRepository.findById(id);
    List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
    menuItems.add(new MenuItem("Pizza"));
    restaurant.setMenuItems(menuItems);
    return restaurant;
  }
}
