package com.didorg.customerms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.didorg.customerms.dto.CustomerDTO;
import com.didorg.customerms.mapper.CustomerMapper;
import com.didorg.customerms.persistance.domain.Customer;
import com.didorg.customerms.service.ICustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	private final CustomerMapper mapper;
	private final ICustomerService service;

	@Autowired
	public CustomerController(CustomerMapper mapper, ICustomerService service) {
		this.mapper = mapper;
		this.service = service;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getCustomer(@PathVariable("id") String id) {
		Optional<Customer> existingCustomer = service.getCustomerById(id);
		if (existingCustomer.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(existingCustomer.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with Id:" + id + " Does not exist");
		}
	}

	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody CustomerDTO customerDTO) {
		Optional<Customer> existingCustomer = service.getCustomerByName(customerDTO.getCustomerName());
		if (!existingCustomer.isPresent()) {
			Customer customerMapped = this.mapper.mapperCustomerDtoToCustomer(customerDTO);
			Customer customerSaved = this.service.saveCustomer(customerMapped);

			return ResponseEntity.status(HttpStatus.CREATED).body(customerSaved);
		} else {
			return ResponseEntity.status(HttpStatus.FOUND)
					.body("Customer " + customerDTO.getCustomerName() + " already exist");
		}
	}

	@PutMapping
	public ResponseEntity<?> updateCustomer(@RequestBody CustomerDTO customerDTO) {
		Optional<Customer> existingCustomer = service.getCustomerById(customerDTO.getId());
		if (existingCustomer.isPresent()) {
			Customer customerMapped = this.mapper.mapperUpdate(existingCustomer.get(), customerDTO);
			return ResponseEntity.status(HttpStatus.OK).body(this.service.saveCustomer(customerMapped));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Customer " + customerDTO.getId() + " does not exist");
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") String id) {
		Optional<Customer> existingCustomer = service.getCustomerById(id);
		if (existingCustomer.isPresent()) {
			this.service.deleteCustomer(id);
			return ResponseEntity.status(HttpStatus.OK).body("Customer with Id: " + id + " was successfully deleted");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with Id:" + id + " Does not exist");
		}
	}

}
