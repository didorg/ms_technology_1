package com.didorg.restaurantms.persistance.repository;

import com.didorg.restaurantms.persistance.domain.Restaurant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRestaurantRepository extends PagingAndSortingRepository<Restaurant, Long> {
}
