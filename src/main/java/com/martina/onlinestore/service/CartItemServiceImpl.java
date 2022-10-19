package com.martina.onlinestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martina.onlinestore.model.CartItem;
import com.martina.onlinestore.model.Customer;
import com.martina.onlinestore.repository.CartItemRepository;
@Service
public class CartItemServiceImpl implements CartItemService{
	@Autowired
	CartItemRepository cartItemRepository;
	@Override
	public void addItem(CartItem item) {
		cartItemRepository.save(item);
	}
	@Override
	public List<CartItem> findCustomerItems(Customer customer) {
		// TODO Auto-generated method stub
		return cartItemRepository.findCartItemByCustomer(customer);
	}
	@Override
	public void deleteItem(Long id) {
		// TODO Auto-generated method stub
		cartItemRepository.deleteById(id);
	}
	

}
