package com.martina.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martina.onlinestore.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Long>{

}
