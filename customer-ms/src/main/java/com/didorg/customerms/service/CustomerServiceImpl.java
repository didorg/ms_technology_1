package com.didorg.customerms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didorg.customerms.persistance.domain.Customer;
import com.didorg.customerms.persistance.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

  private final ICustomerRepository repository;

  @Autowired
  public CustomerServiceImpl(ICustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<Customer> getCustomerById(String id) {
    return repository.findById(Long.valueOf(id));
  }

  @Override
  public Optional<Customer> getCustomerByName(String name) {
    return repository.findByCustomerName(name);
  }

  @Override
  public Customer saveCustomer(Customer customer) {
    return repository.save(customer);
  }

  @Override
  public void deleteCustomer(String id) {
    repository.deleteById(Long.valueOf(id));
  }

}
