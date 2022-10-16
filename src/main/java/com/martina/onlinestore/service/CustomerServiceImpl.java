package com.martina.onlinestore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.martina.onlinestore.dto.CustomerDto;
import com.martina.onlinestore.model.Customer;
import com.martina.onlinestore.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
private CustomerRepository customerRepository;
private PasswordEncoder  passwordEncoder;


public CustomerServiceImpl(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
	super();
	this.customerRepository = customerRepository;
	this.passwordEncoder = passwordEncoder;
}
@Override
public void saveCustomer(CustomerDto customerDto) {
	// TODO Auto-generated method stub
	Customer customer = new Customer();
	customer.setFirstName(customerDto.getFirstName());
	customer.setLastName(customerDto.getLastName());
	customer.setAddress(customerDto.getAddress());
	customer.setCity(customerDto.getCity());
	customer.setState(customerDto.getState());
	customer.setEmail(customerDto.getEmail());
	customer.setPassword(passwordEncoder.encode(customerDto.getPassword()));
	customerRepository.save(customer);
	
	
}
@Override
public Customer findCustomerByEmail(String email) {
	// TODO Auto-generated method stub
	return customerRepository.findByEmail(email);
}
@Override
public List<CustomerDto> findAllCustomers() {
	// TODO Auto-generated method stub
	List<Customer> customers = customerRepository.findAll();
	return customers.stream().map((customer)->maptoCustomerDto(customer)).collect(Collectors.toList());
}
private CustomerDto maptoCustomerDto(Customer customer) {
	CustomerDto customerDto = new CustomerDto();
	customerDto.setFirstName(customer.getFirstName());
	customerDto.setLastName(customer.getLastName());
	customerDto.setAddress(customer.getAddress());
	customerDto.setCity(customer.getCity());
	customerDto.setState(customer.getState());
	customerDto.setEmail(customer.getEmail());
	return customerDto;
	
}
@Override
public Customer getCurrentlyLoggedInCustomer(Authentication authentication) {
	if(authentication == null ) return null;
	Customer customer = null;
	Object principal = authentication.getPrincipal();
	if(principal instanceof UserDetails) {
		customer = (Customer) ((UserDetails)principal);
	}
	return customer;
}


}
