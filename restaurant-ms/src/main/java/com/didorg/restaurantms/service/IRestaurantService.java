package com.didorg.restaurantms.service;

import java.util.Optional;

import com.didorg.restaurantms.persistence.domain.Restaurant;

public interface IRestaurantService {
  Optional<Restaurant> getRestaurantByName(String restaurantName);

  Optional<Restaurant> getRestaurantById(String id);

  Restaurant saveRestaurant(Restaurant restaurant);

  void deleteRestaurant(String id);
}
