package com.didorg.orderms.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.didorg.orderms.persistence.domain.RestaurantOrder;

public interface IOrderRepository extends PagingAndSortingRepository<RestaurantOrder, Long>{

}
