package com.martina.onlinestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martina.onlinestore.model.CartItem;
import com.martina.onlinestore.repository.CartItemRepository;
@Service
public class CartItemServiceImpl implements CartItemService{
	@Autowired
	CartItemRepository cartItemRepository;
	@Override
	public void addItem(CartItem item) {
		cartItemRepository.save(item);
	}
	

}
