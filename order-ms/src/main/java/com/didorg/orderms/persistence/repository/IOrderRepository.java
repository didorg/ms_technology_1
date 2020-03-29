package com.didorg.orderms.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.didorg.orderms.persistence.domain.RestaurantOrder;

@Repository
public interface IOrderRepository extends PagingAndSortingRepository<RestaurantOrder, Long> {
	Optional<RestaurantOrder> findByOrderNumber(String orderNumber);
}
