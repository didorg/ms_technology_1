package com.didorg.orderms.dto.api.customer;

public class Customer {
  private String id, customerName, customerLocation;

  public Customer() {}

  public String getId() {
    return id;
  }

  public void setId(String id) {
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
