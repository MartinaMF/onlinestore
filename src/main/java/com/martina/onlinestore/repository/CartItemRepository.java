package com.martina.onlinestore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martina.onlinestore.model.CartItem;
import com.martina.onlinestore.model.Customer;

public interface CartItemRepository extends JpaRepository<CartItem,Long>{
List<CartItem> findCartItemByCustomer(Customer customer);
}
