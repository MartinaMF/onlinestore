package com.martina.onlinestore.service;

import com.martina.onlinestore.model.Product;

public interface ProductService {
void saveProduct(Product product);
Product findProductByName(String name);
}
