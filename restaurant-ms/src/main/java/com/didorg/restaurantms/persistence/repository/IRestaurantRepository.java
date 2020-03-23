package com.didorg.restaurantms.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.didorg.restaurantms.persistence.domain.Restaurant;

public interface IRestaurantRepository extends PagingAndSortingRepository<Restaurant, Long> {
}
