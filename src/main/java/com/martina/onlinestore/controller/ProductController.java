package com.martina.onlinestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.martina.onlinestore.model.CartItem;
import com.martina.onlinestore.model.Category;
import com.martina.onlinestore.model.Product;
import com.martina.onlinestore.service.CategoryService;
import com.martina.onlinestore.service.ProductService;

import jakarta.validation.Valid;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
@GetMapping("/add_product")
public String addPategory(Model model) {
	Product product = new Product();
	model.addAttribute(product);
	List<Category> categories = categoryService.findAllCategories();
	model.addAttribute("categories",categories);
	return "add_product";
}
@PostMapping("/add_product/save")
public String savePategory(@Valid @ModelAttribute("product")Product product,BindingResult result,Model model) {
	 Product existingProduct = productService.findProductByName(product.getName());
	 if(existingProduct != null && existingProduct.getName()!=null && !existingProduct.getName().isEmpty()) {
		 result.rejectValue("name", null, "there is Prodduct with the same name");
	 }
	if(result.hasErrors()) {
		model.addAttribute("product",product);
		return "add_product";
		
	}
	productService.saveProduct(product);
	return "redirect:/add_product?success";
}
@GetMapping("/products")
public String AllProducts(Model model) {
	List products = productService.findAllProducts();
	model.addAttribute("products",products);
	return "products";
}

}
