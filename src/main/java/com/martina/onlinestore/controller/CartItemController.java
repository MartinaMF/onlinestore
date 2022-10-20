package com.martina.onlinestore.controller;

import java.util.List;

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

import com.martina.onlinestore.model.CartItem;
import com.martina.onlinestore.model.Customer;
import com.martina.onlinestore.model.Product;
import com.martina.onlinestore.service.CartItemService;
import com.martina.onlinestore.service.CustomerService;
import com.martina.onlinestore.service.ProductService;


@Controller
public class CartItemController {
	@Autowired
	ProductService productService;
	@Autowired
	CartItemService cartItemService;
	@Autowired
	CustomerService customerService;
	/**
	 * return cart items based on currently logged in user
	 * @param model
	 * @param authentication
	 * @return
	 */
	@GetMapping("/cart")
	public String cart(Model model,@AuthenticationPrincipal Authentication authentication) {
		authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Customer customer = customerService.findCustomerByEmail(currentPrincipalName);
		List<CartItem> customerItems = cartItemService.findCustomerItems(customer);
		model.addAttribute("customerItems",customerItems);
		model.addAttribute("name",currentPrincipalName);
		return "cart";
	}
	/**
	 * add item to cart
	 * @param id
	 * @param model
	 * @param authentication
	 * @return
	 */
	@RequestMapping(value="/add_to_cart/{id}", method={RequestMethod.POST,RequestMethod.GET})
	public String addItemToCart(@PathVariable(value="id") Long id,Model model,@AuthenticationPrincipal Authentication authentication) {
		authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalEmail = authentication.getName();
		Customer currentCustomer = customerService.findCustomerByEmail(currentPrincipalEmail);
		Product product = productService.findById(id);
		CartItem item = new CartItem();
		item.setCustomer(currentCustomer);
		item.setPrice(product.getPrice());
		item.setProduct(product);
		item.setQuantity(2);
		cartItemService.addItem(item);
		return "redirect:/products?success";
		
	}
	/**
	 * delete item from the cart
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/cart/delete/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteCategory(@PathVariable(value="id") Long id) {
		cartItemService.deleteItem(id);
		return "redirect:/cart?success";
	}

}
