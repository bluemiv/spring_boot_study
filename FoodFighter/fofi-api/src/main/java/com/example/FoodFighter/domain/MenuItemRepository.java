package com.example.FoodFighter.domain;

import java.util.List;

public interface MenuItemRepository {
  List<MenuItem> findAllByRestaurantId(Long id);
}
