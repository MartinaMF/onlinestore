package com.martina.onlinestore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long categoryId;
private String categoryName;
private String description;
private String image;
@ManyToOne
private Admin admin;
//Empty Constructor
public Category() {
	
}
//Constructor with parameters
public Category(Long categoryId, String categoryName, String description, String image, Admin admin) {
	super();
	this.categoryId = categoryId;
	this.categoryName = categoryName;
	this.description = description;
	this.image = image;
	this.admin = admin;
}
public Long getCategoryId() {
	return categoryId;
}
public void setCategoryId(Long categoryId) {
	this.categoryId = categoryId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
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


}

