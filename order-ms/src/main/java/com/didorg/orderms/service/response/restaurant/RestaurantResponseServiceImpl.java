package com.didorg.orderms.service.response.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.didorg.orderms.dto.api.restaurant.Restaurant;

@RefreshScope
@Service
public class RestaurantResponseServiceImpl implements IRestaurantResponseService{
	private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantResponseServiceImpl.class);
	private final RestTemplate restTemplate;
	@Value("${restaurant.rest.host}")
    private String restaurantHostUrl;

	public RestaurantResponseServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Restaurant getRestaurantById(String id) {
		LOGGER.info("GET to Restaurant REST HOST URL --> "+restaurantHostUrl);
		ResponseEntity<Restaurant> entity = restTemplate.getForEntity(restaurantHostUrl + id,
				Restaurant.class);
		LOGGER.info("Status code value: " + entity.getStatusCodeValue());
		LOGGER.info("HTTP Header 'ContentType': " + entity.getHeaders().getContentType());

		return entity.getBody();
	}
}
