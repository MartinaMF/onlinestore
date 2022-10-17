package com.martina.onlinestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martina.onlinestore.model.Product;
import com.martina.onlinestore.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;
	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
		
	}
	
	@Override
	public Product findProductByName(String name) {
	Product product = productRepository.findByName(name);
	return product;
	}

	@Override
	public List<Product> findAllProducts() {
		List products = productRepository.findAll();
		return products;
	}

}
