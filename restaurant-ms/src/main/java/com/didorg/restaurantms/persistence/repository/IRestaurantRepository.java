package com.didorg.restaurantms.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.didorg.restaurantms.persistence.domain.Restaurant;

@Repository
public interface IRestaurantRepository extends PagingAndSortingRepository<Restaurant, Long> {
  Optional<Restaurant> findByRestaurantName(String restaurantName);

}
