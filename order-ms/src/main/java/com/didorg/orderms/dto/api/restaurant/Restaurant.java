package com.didorg.orderms.dto.api.restaurant;

public class Restaurant {
  private String id, restaurantName, restaurantLocation;

  public Restaurant() {}

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getRestaurantName() {
    return restaurantName;
  }

  public void setRestaurantName(String restaurantName) {
    this.restaurantName = restaurantName;
  }

  public String getRestaurantLocation() {
    return restaurantLocation;
  }

  public void setRestaurantLocation(String restaurantLocation) {
    this.restaurantLocation = restaurantLocation;
  }

}
