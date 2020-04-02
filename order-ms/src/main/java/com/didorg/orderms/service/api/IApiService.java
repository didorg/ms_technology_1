package com.didorg.orderms.service.api;

import java.util.concurrent.ExecutionException;

import com.didorg.orderms.dto.api.customer.Customer;
import com.didorg.orderms.dto.api.restaurant.Restaurant;

public interface IApiService {
	Customer getCustomerById(String id) throws InterruptedException, ExecutionException;
	Restaurant getRestaurantById(String id) throws InterruptedException, ExecutionException;
}
