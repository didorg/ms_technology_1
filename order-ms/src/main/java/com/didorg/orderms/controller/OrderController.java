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
import com.didorg.orderms.mapper.OrderMapper;
import com.didorg.orderms.persistence.domain.RestaurantOrder;
import com.didorg.orderms.service.IOrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	private final IOrderService service;
	private final OrderMapper mapper;

	@Autowired
	public OrderController(IOrderService service, OrderMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping(value = "/{orderNumber}")
	public ResponseEntity<?> getOrder(@PathVariable("orderNumber") String orderNumber) {
		Optional<RestaurantOrder> existingOrder = service.getOrderByNumber(orderNumber);
		if (existingOrder.isPresent()) {
			// TODO: This need to be done by API Composition pattern fetching customer and
			// restaurant to compose the order
			return ResponseEntity.status(HttpStatus.OK).body(existingOrder.get());
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
