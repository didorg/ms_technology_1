package com.didorg.orderms.dto;

import java.util.Date;

import com.didorg.orderms.dto.api.customer.Customer;
import com.didorg.orderms.dto.api.restaurant.Restaurant;

public class OrderResponse {

	private String id, orderNumber;
	private Date createdAt;
	private Customer customer;
	private Restaurant restaurant;

	public OrderResponse() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
