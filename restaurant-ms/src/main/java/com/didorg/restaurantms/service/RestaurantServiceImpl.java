package com.didorg.restaurantms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didorg.restaurantms.persistence.domain.Restaurant;
import com.didorg.restaurantms.persistence.repository.IRestaurantRepository;

@Service
public class RestaurantServiceImpl implements IRestaurantService{
	
	private final IRestaurantRepository repository;
	
	@Autowired
	public RestaurantServiceImpl(IRestaurantRepository repository) {		
		this.repository = repository;
	}

	@Override
	public Optional<Restaurant> getRestaurantByName(String restaurantName) {		
		return repository.findByRestaurantName(restaurantName);
	}

	@Override
	public Restaurant saveRestaurant(Restaurant restaurant) {		
		return repository.save(restaurant);
	}
	
	@Override
	public void deleteRestaurant(String id) {
		repository.deleteById(Long.valueOf(id));		
	}

	@Override
	public Optional<Restaurant> getRestaurantById(String id) {		
		return repository.findById(Long.valueOf(id));
	}

}
