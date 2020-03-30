package com.didorg.orderms.service.response.restaurant;

import com.didorg.orderms.dto.api.restaurant.Restaurant;

public interface IRestaurantResponseService {
	Restaurant getRestaurantById(String id);
}
