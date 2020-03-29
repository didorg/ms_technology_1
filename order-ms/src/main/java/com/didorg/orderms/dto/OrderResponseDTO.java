package com.didorg.orderms.dto;

import com.didorg.orderms.dto.api.customer.CustomerDTO;
import com.didorg.orderms.dto.api.restaurant.RestaurantDTO;

public class OrderResponseDTO {
	private String orderNumber;
	private String createdAt;
	private CustomerDTO customerDTO;
	private RestaurantDTO restaurantDTO;
	
	public OrderResponseDTO() {
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}

	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}

	public RestaurantDTO getRestaurantDTO() {
		return restaurantDTO;
	}

	public void setRestaurantDTO(RestaurantDTO restaurantDTO) {
		this.restaurantDTO = restaurantDTO;
	}

}
