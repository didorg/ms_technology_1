package com.didorg.orderms.service.response.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.didorg.orderms.dto.api.customer.Customer;

@RefreshScope
@Service
@RibbonClient(name = "customerRibbon")
public class CustomerResponseServiceImpl implements ICustomerResponseService{
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerResponseServiceImpl.class);
	private static final String RIBBON = "http://customerRibbon/";
	private static final String CUSTOMER = "customers/";
	
	private final RestTemplate restTemplate;
	@Value("${customer.rest.host}")
    private String customertHostUrl;

	public CustomerResponseServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Customer getCustomerById(String id) {
		LOGGER.info("GET to Customer REST HOST URL --> "+RIBBON + CUSTOMER + id);
		ResponseEntity<Customer> entity = restTemplate.getForEntity(RIBBON + CUSTOMER + id,
				Customer.class);
		LOGGER.info("Status code value: " + entity.getStatusCodeValue());
		LOGGER.info("HTTP Header 'ContentType': " + entity.getHeaders().getContentType());

		return entity.getBody();
	}
}
