package com.martina.onlinestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.martina.onlinestore.model.CartItem;
import com.martina.onlinestore.service.CartItemService;


@Controller
public class CartItemController {
	
	CartItemService cartItemService;
	@PostMapping("add_to_cart")
	public String AddToCart(BindingResult result,Model model) {
		CartItem item = new CartItem();
		return "redirect:/add_to_cart?success";
	}
}
