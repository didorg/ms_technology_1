package com.didorg.orderms.mapper;

import org.springframework.stereotype.Component;

import com.didorg.orderms.dto.OrderResponse;
import com.didorg.orderms.dto.api.customer.Customer;
import com.didorg.orderms.dto.api.restaurant.Restaurant;
import com.didorg.orderms.persistence.domain.RestaurantOrder;

@Component
public class OrderResponseMapper {

  public OrderResponse mapperOrderResponse(RestaurantOrder order, Customer apiCustomer,
      Restaurant apiRestaurant) {
    OrderResponse oResponse = new OrderResponse();

    oResponse.setId(order.getId().toString());
    oResponse.setOrderNumber(order.getOrderNumber());
    oResponse.setCreatedAt(order.getCreatedAt());
    oResponse.setCustomer(this.mapperApiCustomerToCustomerResponse(apiCustomer));
    oResponse.setRestaurant(this.mapperApiRestaurantToRestaurantResponse(apiRestaurant));

    return oResponse;
  }

  private Customer mapperApiCustomerToCustomerResponse(Customer apiCustomer) {
    Customer customer = new Customer();

    customer.setId(apiCustomer.getId());
    customer.setCustomerName(apiCustomer.getCustomerName());
    customer.setCustomerLocation(apiCustomer.getCustomerLocation());

    return customer;
  }

  private Restaurant mapperApiRestaurantToRestaurantResponse(Restaurant apiRestaurant) {
    Restaurant restaurant = new Restaurant();

    restaurant.setId(apiRestaurant.getId());
    restaurant.setRestaurantName(apiRestaurant.getRestaurantName());
    restaurant.setRestaurantLocation(apiRestaurant.getRestaurantLocation());

    return restaurant;
  }

}
