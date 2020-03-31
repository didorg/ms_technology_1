package com.didorg.orderms.service.response.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.didorg.orderms.dto.api.restaurant.Restaurant;

@RefreshScope
@Service
@RibbonClient(name = "restaurantRibbon")
public class RestaurantResponseServiceImpl implements IRestaurantResponseService{
	private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantResponseServiceImpl.class);
	private static final String RIBBON = "http://restaurantRibbon/";
	private static final String RESTAURANT = "restaurants/";
	private final RestTemplate restTemplate;
	@Value("${restaurant.rest.host}")
    private String restaurantHostUrl;

	public RestaurantResponseServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Restaurant getRestaurantById(String id) {
		LOGGER.info("GET to Restaurant REST HOST URL --> "+RIBBON + RESTAURANT + id);
		ResponseEntity<Restaurant> entity = restTemplate.getForEntity(RIBBON + RESTAURANT + id,
				Restaurant.class);
		LOGGER.info("Status code value: " + entity.getStatusCodeValue());
		LOGGER.info("HTTP Header 'ContentType': " + entity.getHeaders().getContentType());

		return entity.getBody();
	}
}
