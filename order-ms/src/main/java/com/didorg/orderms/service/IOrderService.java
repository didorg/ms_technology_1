package com.didorg.orderms.service;

import java.util.Optional;

import com.didorg.orderms.persistence.domain.RestaurantOrder;

public interface IOrderService {
  Optional<RestaurantOrder> getOrderById(String id);

  RestaurantOrder saveOrder(RestaurantOrder order);

  void deleteOrder(String id);

  Optional<RestaurantOrder> getOrderByNumber(String orderNumber);
}
