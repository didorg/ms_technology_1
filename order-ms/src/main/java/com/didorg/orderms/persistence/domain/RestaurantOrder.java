package com.didorg.orderms.persistence.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
public class RestaurantOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "order_number", nullable = false)
    private String orderNumber;
    
    @Column(name = "restaurant_id", nullable = false)
    private String restaurantId;
    
    @Column(name = "customer_id", nullable = false)
    private String customerId;
    
    @Column(name = "created_at", nullable = false)
    private Date createdAt = new Date();

    public RestaurantOrder() {
    }

    public RestaurantOrder(Long id, String orderNumber, String restaurantId, String customerId, Date createdAt) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.restaurantId = restaurantId;
		this.customerId = customerId;
		this.createdAt = createdAt;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
    
}
