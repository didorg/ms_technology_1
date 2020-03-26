package com.didorg.customerms.service;

import java.util.Optional;

import com.didorg.customerms.persistance.domain.Customer;

public interface ICustomerService {
	Optional<Customer> getCustomerById(String id);
	Optional<Customer> getCustomerByName(String name);
	Customer saveCustomer(Customer customer);	
	void deleteCustomer(String id);
}
