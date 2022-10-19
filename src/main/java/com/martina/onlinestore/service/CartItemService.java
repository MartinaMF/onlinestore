package com.martina.onlinestore.service;

import java.util.List;

import com.martina.onlinestore.model.CartItem;
import com.martina.onlinestore.model.Customer;

public interface CartItemService {
void addItem(CartItem item);
List <CartItem> findCustomerItems(Customer customer);
void deleteItem(Long id);
}
