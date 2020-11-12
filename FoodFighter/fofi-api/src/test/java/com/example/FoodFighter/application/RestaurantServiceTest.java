package com.example.FoodFighter.application;

import com.example.FoodFighter.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestaurantServiceTest {

  private RestaurantService restaurantService;
  private RestaurantRepository restaurantRepository;
  private MenuItemRepository menuItemRepository;

  @BeforeEach
  public void setUp() {
    restaurantRepository = new RestaurantRepositoryImpl();
    menuItemRepository = new MenuItemRepositoryImpl();

    restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
  }

  @Test
  public void getRestaurant() {
    Restaurant restaurant = restaurantService.getRestaurant(1004L);
    Assertions.assertEquals(1004L, restaurant.getId());
    Assertions.assertEquals("Pizza", restaurant.getMenuItems().get(0).getName());
  }
}
