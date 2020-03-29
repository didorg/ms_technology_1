package com.didorg.orderms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didorg.orderms.persistence.domain.RestaurantOrder;
import com.didorg.orderms.persistence.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {

	private final IOrderRepository repository;

	@Autowired
	public OrderServiceImpl(IOrderRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<RestaurantOrder> getOrderById(String id) {
		return repository.findById(Long.valueOf(id));
	}
	
	@Override
	public Optional<RestaurantOrder> getOrderByNumber(String orderNumber) {
		
		return repository.findByOrderNumber(orderNumber);
	}

	@Override
	public RestaurantOrder saveOrder(RestaurantOrder order) {
		return repository.save(order);
	}

	@Override
	public void deleteOrder(String id) {
		repository.deleteById(Long.valueOf(id));
	}

}
