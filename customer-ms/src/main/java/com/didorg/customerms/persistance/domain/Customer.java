package com.didorg.customerms.persistance.domain;

import javax.persistence.*;

@Entity
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "customer_name", nullable = false)
  private String customerName;
  @Column(name = "customer_location", nullable = false)
  private String customerLocation;

  public Customer() {}

  public Customer(Long id, String customerName, String customerLocation) {
    this.id = id;
    this.customerName = customerName;
    this.customerLocation = customerLocation;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getCustomerLocation() {
    return customerLocation;
  }

  public void setCustomerLocation(String customerLocation) {
    this.customerLocation = customerLocation;
  }
}
