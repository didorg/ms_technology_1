package com.didorg.orderms.service.api.customer;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.didorg.orderms.dto.api.customer.Customer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;

@Service
public class CustomerHystrixService {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerHystrixService.class);
  private static final String RIBBON = "http://customerMS/";
  private static final String CUSTOMER = "customers/";

  private final RestTemplate restTemplate;

  public CustomerHystrixService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @HystrixCommand(fallbackMethod = "getCustomerByIdFallback")
  public Future<Customer> getCustomerByIdAsync(final String id) {
    // Asynchronous Execution
    return new AsyncResult<Customer>() {
      @Override
      public Customer invoke() {
        LOGGER.info("GET to Customer REST HOST URL --> " + RIBBON + CUSTOMER + id);
        ResponseEntity<Customer> entity =
            restTemplate.getForEntity(RIBBON + CUSTOMER + id, Customer.class);
        LOGGER.info("Status code value: " + entity.getStatusCodeValue());
        LOGGER.info("HTTP Header 'ContentType': " + entity.getHeaders().getContentType());

        return entity.getBody();
      }
    };
  }

  public Customer getCustomerByIdFallback(String id) {
    return new Customer();
  }

}
