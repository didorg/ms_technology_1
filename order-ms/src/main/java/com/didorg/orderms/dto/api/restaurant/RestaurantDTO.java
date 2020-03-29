package com.didorg.orderms.dto.api.restaurant;

public class RestaurantDTO {
	private String restaurantName, restaurantLocation;

	public RestaurantDTO() {
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
