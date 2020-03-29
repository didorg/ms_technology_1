package com.didorg.orderms.mapper;

import org.springframework.stereotype.Component;

import com.didorg.orderms.dto.OrderDTO;
import com.didorg.orderms.persistence.domain.RestaurantOrder;

@Component
public class OrderMapper {

	public RestaurantOrder mapperOrdeDtoToRestaurantOrder(OrderDTO orderDTO) {
		RestaurantOrder rOrder = new RestaurantOrder();
		
		rOrder.setCustomerId(orderDTO.getCustomerId());
		rOrder.setRestaurantId(orderDTO.getRestaurantId());
		rOrder.setOrderNumber(orderDTO.getOrderNumber());
		
		return rOrder;
	}

	public RestaurantOrder mapperUpdate(RestaurantOrder existingOrder, OrderDTO orderDTO) {
		
		existingOrder.setId(Long.valueOf(orderDTO.getId()));
		existingOrder.setOrderNumber(orderDTO.getOrderNumber());
		existingOrder.setCustomerId(orderDTO.getCustomerId());
		existingOrder.setRestaurantId(orderDTO.getRestaurantId());
		
		return existingOrder;
		
	}

}
