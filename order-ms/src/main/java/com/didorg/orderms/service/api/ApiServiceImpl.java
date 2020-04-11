package com.didorg.orderms.service.api;


import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import com.didorg.orderms.dto.api.customer.Customer;
import com.didorg.orderms.dto.api.restaurant.Restaurant;
import com.didorg.orderms.service.api.customer.CustomerHystrixService;
import com.didorg.orderms.service.api.restaurant.RestaurantHystrixService;

@RefreshScope
@Service
public class ApiServiceImpl implements IApiService {

  private final CustomerHystrixService customerHystrixService;
  private final RestaurantHystrixService restaurantHystrixService;

  @Autowired
  public ApiServiceImpl(CustomerHystrixService customerHystrixService,
      RestaurantHystrixService restaurantHystrixService) {
    this.customerHystrixService = customerHystrixService;
    this.restaurantHystrixService = restaurantHystrixService;
  }


  public Customer getCustomerById(String id) throws InterruptedException, ExecutionException {
    return this.customerHystrixService.getCustomerByIdAsync(id).get();
  }

  public Restaurant getRestaurantById(String id) throws InterruptedException, ExecutionException {
    return this.restaurantHystrixService.getRestaurantByIdAsync(id).get();
  }
}
