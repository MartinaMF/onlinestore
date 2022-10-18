package com.martina.onlinestore.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "cart_items")
public class CartItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long Id;
	@ManyToOne
	@JoinColumn(name = "product_id")
private Product product;
	@ManyToOne
	@JoinColumn(name = "customer_id")
private Customer customer;
private int quantity;
private double price;

public CartItem() {
	
}

public CartItem(Product product, Customer customer, int quantity, double price) {
	super();
	this.product = product;
	this.customer = customer;
	this.quantity = quantity;
	this.price = price;
}

public CartItem(Long id, Product product, Customer customer, int quantity, double price) {
	super();
	Id = id;
	this.product = product;
	this.customer = customer;
	this.quantity = quantity;
	this.price = price;
}

public Long getId() {
	return Id;
}

public void setId(Long id) {
	Id = id;
}

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

@Override
public String toString() {
	return "CartItem [Id=" + Id + ", product=" + product + ", customer=" + customer + ", quantity=" + quantity
			+ ", price=" + price + "]";
}


	







}
