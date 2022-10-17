package com.martina.onlinestore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martina.onlinestore.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
Product findByName(String name);
List<Product> findAll();
}
