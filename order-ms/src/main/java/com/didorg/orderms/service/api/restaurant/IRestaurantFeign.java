package com.didorg.orderms.service.api.restaurant;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.didorg.orderms.dto.api.restaurant.Restaurant;

@FeignClient("restaurantMS")
public interface IRestaurantFeign {
	
	@RequestMapping(value = "/restaurants/{id}")	
	ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") String id);
}
