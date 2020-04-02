package com.didorg.orderms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.didorg.orderms.dto.OrderDTO;
import com.didorg.orderms.dto.OrderResponse;
import com.didorg.orderms.dto.api.customer.Customer;
import com.didorg.orderms.dto.api.restaurant.Restaurant;
import com.didorg.orderms.mapper.OrderMapper;
import com.didorg.orderms.mapper.OrderResponseMapper;
import com.didorg.orderms.persistence.domain.RestaurantOrder;
import com.didorg.orderms.service.IOrderService;
import com.didorg.orderms.service.api.IApiService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	private final IOrderService service;
	private final OrderMapper mapper;
	private final OrderResponseMapper mapperResponse;
	private final IApiService apiService;

	@Autowired
	public OrderController(IOrderService service, OrderMapper mapper, OrderResponseMapper mapperResponse, IApiService apiService) {
		this.service = service;
		this.mapper = mapper;
		this.mapperResponse = mapperResponse;
		this.apiService = apiService;
	}

	@GetMapping(value = "/{orderNumber}")
	public ResponseEntity<?> getOrder(@PathVariable("orderNumber") String orderNumber) {
		Optional<RestaurantOrder> existingOrder = service.getOrderByNumber(orderNumber);
		if (existingOrder.isPresent()) {
			RestaurantOrder order = existingOrder.get();
			// API Composition Pattern to compose the Order, fetching Customer and Restaurant
			Customer apiCustomer = this.apiService.getCustomerById(order.getCustomerId());
			Restaurant apiRestaurant = this.apiService.getRestaurantById(order.getRestaurantId());
			OrderResponse orderResponse = this.mapperResponse.mapperOrderResponse(order, apiCustomer, apiRestaurant);
			return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order with Id:" + orderNumber + " Does not exist");
		}
	}

	@PostMapping
	public ResponseEntity<?> addOrder(@RequestBody OrderDTO orderDTO) {
		Optional<RestaurantOrder> existingOrder = service.getOrderByNumber(orderDTO.getOrderNumber());
		if (!existingOrder.isPresent()) {
			RestaurantOrder orderMapped = this.mapper.mapperOrdeDtoToRestaurantOrder(orderDTO);
			RestaurantOrder orderSaved = this.service.saveOrder(orderMapped);

			return ResponseEntity.status(HttpStatus.CREATED).body(orderSaved);
		} else {
			return ResponseEntity.status(HttpStatus.FOUND)
					.body("Order " + orderDTO.getOrderNumber() + " already exist");
		}
	}

	@PutMapping
	public ResponseEntity<?> updateOrder(@RequestBody OrderDTO orderDTO) {
		Optional<RestaurantOrder> existingOrder = service.getOrderById(orderDTO.getId());
		if (existingOrder.isPresent()) {
			RestaurantOrder orderMapped = this.mapper.mapperUpdate(existingOrder.get(), orderDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(this.service.saveOrder(orderMapped));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order " + orderDTO.getId() + " does not exist");
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable("id") String id) {
		Optional<RestaurantOrder> existingOrder = service.getOrderById(id);
		if (existingOrder.isPresent()) {
			this.service.deleteOrder(id);
			return ResponseEntity.status(HttpStatus.OK).body("Order with Id: " + id + " was successfully deleted");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order with Id:" + id + " Does not exist");
		}
	}

}
