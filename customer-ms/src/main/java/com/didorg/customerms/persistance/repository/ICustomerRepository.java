package com.didorg.customerms.persistance.repository;

import com.didorg.customerms.persistance.domain.Customer;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
  Optional<Customer> findByCustomerName(String customerName);
}
