package com.martina.onlinestore.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.martina.onlinestore.dto.CustomerDto;
import com.martina.onlinestore.model.Customer;

public interface CustomerService {
	
void saveCustomer(CustomerDto customerDto);
Customer findCustomerByEmail(String email);
List<CustomerDto> findAllCustomers();
Customer getCurrentlyLoggedInCustomer(Authentication authentication);

}
