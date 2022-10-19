package com.martina.onlinestore.controller;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
@GetMapping("/dashboard")
public String dashboard() {
	return "dashboard";
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
private org.slf4j.Logger logger =LoggerFactory.getLogger(getClass());
@GetMapping("/login")
public String login() {
	return "login";
}


}
