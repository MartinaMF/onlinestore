package com.martina.onlinestore.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class CustomerDto {

private Long customerId;
	@NotEmpty
private String firstName;
	 @NotEmpty
private String lastName;
	 @NotEmpty
private String address;
	 @NotEmpty(message = "Email should not be empty")
	 @Email
private String email;
	 @NotEmpty(message = "Password should be empty")
private String password;
	 @NotEmpty
private String city;
	 @NotEmpty
private String state;
	public CustomerDto() {}
	public CustomerDto(Long customerId, @NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String address,
			@NotEmpty(message = "Email should not be empty") @Email String email,
			@NotEmpty(message = "Password should be empty") String password, @NotEmpty String city,
			@NotEmpty String state) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.password = password;
		this.city = city;
		this.state = state;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "CustomerDto [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", email=" + email + ", password=" + password + ", city=" + city + ", state="
				+ state + "]";
	}

	
	 
}
