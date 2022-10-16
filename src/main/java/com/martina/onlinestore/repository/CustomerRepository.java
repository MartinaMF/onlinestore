package com.martina.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martina.onlinestore.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
Customer findByEmail(String email);
}
