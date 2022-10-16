package com.martina.onlinestore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long productId;
private String name;
private double price;
private String description;
private int quantity;
private int quantityOrdred;
private String image;
@ManyToOne
private Admin admin;
@ManyToOne
private Category category;
public Product() {
	
}


public Product(Long productId, String name, double price, String description, int quantity, int quantityOrdred,
		String image, Admin admin, Category category) {
	super();
	this.productId = productId;
	this.name = name;
	this.price = price;
	this.description = description;
	this.quantity = quantity;
	this.quantityOrdred = quantityOrdred;
	this.image = image;
	this.admin = admin;
	this.category = category;
}



public Long getProductId() {
	return productId;
}

public void setProductId(Long productId) {
	this.productId = productId;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}



public int getQuantityOrdred() {
	return quantityOrdred;
}

public void setQuantityOrdred(int quantityOrdred) {
	this.quantityOrdred = quantityOrdred;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public Admin getAdmin() {
	return admin;
}

public void setAdmin(Admin admin) {
	this.admin = admin;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}

}

