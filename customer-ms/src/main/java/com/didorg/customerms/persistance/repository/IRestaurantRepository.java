package com.didorg.customerms.persistance.repository;

import com.didorg.customerms.persistance.domain.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRestaurantRepository extends PagingAndSortingRepository<Customer, Long> {
}
