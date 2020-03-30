package com.didorg.orderms.service.response.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.didorg.orderms.dto.api.customer.Customer;


@Service
public class CustomerResponseServiceImpl implements ICustomerResponseService{
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerResponseServiceImpl.class);
	private final RestTemplate restTemplate;

	public CustomerResponseServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Customer getCustomerById(String id) {
		ResponseEntity<Customer> entity = restTemplate.getForEntity("http://localhost:8041/customers/" + id,
				Customer.class);
		LOGGER.info("Status code value: " + entity.getStatusCodeValue());
		LOGGER.info("HTTP Header 'ContentType': " + entity.getHeaders().getContentType());

		return entity.getBody();
	}
}
