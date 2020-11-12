package com.example.FoodFighter.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTests {

    @Test
    public void creation() {
        Restaurant restaurant = new Restaurant("My Food House", "Seoul");
        assertEquals("My Food House", restaurant.getName());
        assertEquals("Seoul", restaurant.getAddress());
    }

    @Test
    public void information() {
        Restaurant restaurant = new Restaurant("Test Food zip", "Seoul");
        assertEquals("Test Food zip in Seoul", restaurant.getInformation());
    }

}