package com.didorg.orderms.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebClientConfiguration {

	@Bean @LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
