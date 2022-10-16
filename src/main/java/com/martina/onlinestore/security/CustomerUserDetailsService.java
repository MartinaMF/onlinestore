package com.martina.onlinestore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.martina.onlinestore.model.Customer;
import com.martina.onlinestore.repository.CustomerRepository;
@Service
public class CustomerUserDetailsService implements UserDetailsService{
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findByEmail(email);
		if(customer == null) {
			throw new UsernameNotFoundException(email);
		}
		UserDetails user = User.withUsername(customer.getEmail()).password(customer.getPassword()).authorities("USER").build();
		return user;
	}

}
