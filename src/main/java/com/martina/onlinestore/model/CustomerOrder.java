package com.martina.onlinestore.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class CustomerOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long orderId;
private Date  date;
private float total;
@OneToMany(targetEntity=CartItem.class, cascade=(CascadeType.ALL))
private Set<CartItem> cartItems;
@ManyToOne
private Customer customer;
public CustomerOrder() {
	
}
public CustomerOrder(Long orderId, Date date, float total, Set<CartItem> cartItems, Customer customer) {
	super();
	this.orderId = orderId;
	this.date = date;
	this.total = total;
	this.cartItems = cartItems;
	this.customer = customer;
}
public Long getOrderId() {
	return orderId;
}
public void setOrderId(Long orderId) {
	this.orderId = orderId;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public float getTotal() {
	return total;
}
public void setTotal(float total) {
	this.total = total;
}
public Set<CartItem> getCartItems() {
	return cartItems;
}
public void setCartItems(Set<CartItem> cartItems) {
	this.cartItems = cartItems;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
@Override
public String toString() {
	return "CustomerOrder [orderId=" + orderId + ", date=" + date + ", total=" + total + ", cartItems=" + cartItems
			+ ", customer=" + customer + "]";
}



}
