package com.example.FoodFighter.interfaces;

import com.example.FoodFighter.domain.MenuItemRepository;
import com.example.FoodFighter.domain.MenuItemRepositoryImpl;
import com.example.FoodFighter.domain.RestaurantRepository;
import com.example.FoodFighter.domain.RestaurantRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestaurantController.class)
class RestaurantControllerTests {

  @Autowired private MockMvc mvc;

  @SpyBean(RestaurantRepositoryImpl.class)
  private RestaurantRepository restaurantRepository;

  @SpyBean(MenuItemRepositoryImpl.class)
  private MenuItemRepository menuItemRepository;

  @Test
  public void list() throws Exception {
    mvc.perform(get("/restaurant"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"name\":\"My Food House\"")))
        .andExpect(content().string(containsString("\"id\":1004")));
  }

  @Test
  public void detail() throws Exception {
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
