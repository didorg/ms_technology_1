package com.didorg.orderms.service.api;

import com.didorg.orderms.dto.api.customer.Customer;
import com.didorg.orderms.dto.api.restaurant.Restaurant;

public interface IApiService {
	Customer getCustomerById(String id);
	Restaurant getRestaurantById(String id);
}
