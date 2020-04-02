package com.didorg.orderms.service.api.restaurant;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.didorg.orderms.dto.api.restaurant.Restaurant;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;

@Service
public class RestaurantHystrixService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantHystrixService.class);
	private static final String RIBBON = "http://restaurantMS/";
	private static final String RESTAURANT = "restaurants/";
	private final RestTemplate restTemplate;

	public RestaurantHystrixService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@HystrixCommand(fallbackMethod = "getRestaurantByIdFallback")
	public Future<Restaurant> getRestaurantByIdAsync(final String id) {
		// Asynchronous Execution 
		return new AsyncResult<Restaurant>() {
            @Override
            public Restaurant invoke() {
            	LOGGER.info("GET to Restaurant REST HOST URL --> " + RIBBON + RESTAURANT + id);
        		ResponseEntity<Restaurant> entity = restTemplate.getForEntity(RIBBON + RESTAURANT + id, Restaurant.class);
        		LOGGER.info("Status code value: " + entity.getStatusCodeValue());
        		LOGGER.info("HTTP Header 'ContentType': " + entity.getHeaders().getContentType());

        		return entity.getBody();
            }
        };
    }
	
	public Restaurant getRestaurantByIdFallback(String id) {
		return new Restaurant();
	}

}
