package com.martina.onlinestore.service;

import java.util.List;

import com.martina.onlinestore.model.Product;

public interface ProductService {
void saveProduct(Product product);
Product findProductByName(String name);
List<Product> findAllProducts();
Product findById(Long id);
void deleteProduct(Long id);
}
