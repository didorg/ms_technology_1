package com.didorg.customerms.mapper;

import org.springframework.stereotype.Component;

import com.didorg.customerms.dto.CustomerDTO;
import com.didorg.customerms.persistance.domain.Customer;

@Component
public class CustomerMapper {

  public Customer mapperCustomerDtoToCustomer(CustomerDTO customerDTO) {
    Customer customer = new Customer();

    customer.setCustomerName(customerDTO.getCustomerName());
    customer.setCustomerLocation(customerDTO.getCustomerLocation());

    return customer;
  }

  public Customer mapperUpdate(Customer existingCustomer, CustomerDTO CustomerDTO) {

    existingCustomer.setId(Long.valueOf(CustomerDTO.getId()));
    existingCustomer.setCustomerName(CustomerDTO.getCustomerName());
    existingCustomer.setCustomerLocation(CustomerDTO.getCustomerLocation());

    return existingCustomer;
  }

}
