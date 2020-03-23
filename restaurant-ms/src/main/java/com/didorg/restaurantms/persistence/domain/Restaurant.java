package com.didorg.restaurantms.persistence.domain;

import javax.persistence.*;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "restaurant_name", nullable = false)
    private String restaurantName;
    @Column(name = "restaurant_location", nullable = false)
    private String restaurantLocation;

    public Restaurant() {
    }

    public Restaurant(Long id, String restaurantName, String restaurantLocation) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.restaurantLocation = restaurantLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }
}
