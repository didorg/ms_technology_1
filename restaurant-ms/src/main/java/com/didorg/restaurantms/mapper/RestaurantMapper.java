package com.didorg.restaurantms.mapper;

import org.springframework.stereotype.Component;

import com.didorg.restaurantms.dto.RestaurantDTO;
import com.didorg.restaurantms.persistence.domain.Restaurant;

@Component
public class RestaurantMapper {

	public Restaurant mapperRestaurantDtoToRestaurant(RestaurantDTO restaurantDTO) {
		Restaurant restaurant = new Restaurant();
		
		restaurant.setRestaurantName(restaurantDTO.getRestaurantName());
		restaurant.setRestaurantLocation(restaurantDTO.getRestaurantLocation());
		
		return restaurant;
	}

	public Restaurant mapperUpdate(Restaurant existingRestaurant, RestaurantDTO restaurantDTO) {
		
		existingRestaurant.setId(Long.valueOf(restaurantDTO.getId()));
		existingRestaurant.setRestaurantName(restaurantDTO.getRestaurantName());
		existingRestaurant.setRestaurantLocation(restaurantDTO.getRestaurantLocation());
		
		return existingRestaurant;
	}

}
