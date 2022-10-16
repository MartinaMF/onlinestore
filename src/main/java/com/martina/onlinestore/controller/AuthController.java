package com.martina.onlinestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.martina.onlinestore.dto.CustomerDto;
import com.martina.onlinestore.model.Customer;
import com.martina.onlinestore.service.CustomerService;

import jakarta.validation.Valid;

@Controller
public class AuthController {
	@Autowired
	private CustomerService customerService;
	
public AuthController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
@GetMapping("/index")
public String home() {
	return "index";
}
@GetMapping("/register")
public String showRegistrationForm(Model model) {
	//create model object to store form data85841
	CustomerDto customer = new CustomerDto();
	model.addAttribute("customer",customer);
	return "register";
}

@PostMapping("/register/save")
public String registration(@Valid @ModelAttribute("customer") CustomerDto customerdto,
		BindingResult result,Model model) {
	Customer existingUser = customerService.findCustomerByEmail(customerdto.getEmail());
	if(existingUser !=null && existingUser.getEmail()!=null && !existingUser.getEmail().isEmpty()) {
		result.rejectValue("email", null, "there is account with the same email");
		
	}
	if(result.hasErrors()) {
		model.addAttribute("customer", customerdto);
		return "/register";
	}
	customerService.saveCustomer(customerdto);
	return "redirect:/register?success";
}
@GetMapping("/login")
public String login() {
	return "login";
}
@GetMapping("/cart")
public String cart(Model model,@AuthenticationPrincipal Authentication authentication) {
	authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	model.addAttribute("name",currentPrincipalName);
	return "cart";
}

}
