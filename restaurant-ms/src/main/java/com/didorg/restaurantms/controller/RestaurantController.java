package com.didorg.restaurantms.controller;

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

import com.didorg.restaurantms.dto.RestaurantDTO;
import com.didorg.restaurantms.mapper.RestaurantMapper;
import com.didorg.restaurantms.persistence.domain.Restaurant;
import com.didorg.restaurantms.service.IRestaurantService;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {
	
	private final RestaurantMapper mapper;
	private final IRestaurantService service;
	
	@Autowired
	public RestaurantController(RestaurantMapper mapper, IRestaurantService service) {		
		this.mapper = mapper;
		this.service = service;		
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getRestaurant(@PathVariable("id") String id){
		Optional<Restaurant> existingRestaurant = service.getRestaurantById(id);
		if (existingRestaurant.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(existingRestaurant.get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restaurant with Id:"+id+" Does not exist");
		}
	}
	
	@PostMapping
	public ResponseEntity<?> addRestaurant(@RequestBody RestaurantDTO restaurantDTO){
		Optional<Restaurant> existingRestaurant = service.getRestaurantByName(restaurantDTO.getRestaurantName());
		if (!existingRestaurant.isPresent()) {
			Restaurant restaurantMapped = this.mapper.mapperRestaurantDtoToRestaurant(restaurantDTO);
			Restaurant restaurantSaved = this.service.saveRestaurant(restaurantMapped); 
			
			return ResponseEntity.status(HttpStatus.CREATED).body(restaurantSaved);
		}else {
			return ResponseEntity.status(HttpStatus.FOUND).body("Restaurant "+restaurantDTO.getRestaurantName()+" already exist");
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateRestaurant(@RequestBody RestaurantDTO restaurantDTO){
		Optional<Restaurant> existingRestaurant = service.getRestaurantById(restaurantDTO.getId());
		if (existingRestaurant.isPresent()) {			
			Restaurant restaurantMapped = this.mapper.mapperUpdate(existingRestaurant.get(), restaurantDTO);						
			return ResponseEntity.status(HttpStatus.CREATED).body(this.service.saveRestaurant(restaurantMapped));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restaurant "+restaurantDTO.getId()+" does not exist");
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteRestaurant(@PathVariable("id") String id){
		Optional<Restaurant> existingRestaurant = service.getRestaurantById(id);
		if (existingRestaurant.isPresent()) {
			this.service.deleteRestaurant(id);
			return ResponseEntity.status(HttpStatus.OK).body("Restaurant with Id: "+id+" was successfully deleted");
		}else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Restaurant with Id:"+id+" Does not exist");
		}
	}
	
}
