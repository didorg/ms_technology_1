package com.didorg.orderms.mapper;

import org.springframework.stereotype.Component;

import com.didorg.orderms.dto.OrderResponse;
import com.didorg.orderms.persistence.domain.RestaurantOrder;

@Component
public class OrderResponseMapper {

	public OrderResponse mapperOrderResponse(RestaurantOrder rOrder) {
		OrderResponse oResponse = new OrderResponse();
		
		oResponse.setId(rOrder.getId().toString());
		oResponse.setOrderNumber(rOrder.getOrderNumber());
		oResponse.setCreatedAt(rOrder.getCreatedAt());
		oResponse.setCustomer(null);
		oResponse.setRestaurant(null);
		
		return oResponse;
	}

}
