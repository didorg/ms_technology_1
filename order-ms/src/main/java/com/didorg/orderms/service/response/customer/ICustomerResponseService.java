package com.didorg.orderms.service.response.customer;

import com.didorg.orderms.dto.api.customer.Customer;

public interface ICustomerResponseService {
	Customer getCustomerById(String id);
}
