package com.martina.onlinestore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.martina.onlinestore.model.Category;
import com.martina.onlinestore.service.CategoryService;

import jakarta.validation.Valid;


@Controller
public class CategoryController {
	@Autowired
private CategoryService categoryService;
@GetMapping("/add_category")
public String addCategory(Model model) {
	Category category = new Category();
	model.addAttribute(category);
	return "add_category";
} 
@PostMapping("/add_category/save")
public String saveCategory(@Valid @ModelAttribute("category")Category category,BindingResult result,Model model) {
	 Category existingCategory = categoryService.findByCategoryName(category.getCategoryName());
	 if(existingCategory != null && existingCategory.getCategoryName()!=null && !existingCategory.getCategoryName().isEmpty()) {
		 result.rejectValue("categoryName", null, "there is Category with the same name");
	 }
	if(result.hasErrors()) {
		model.addAttribute("category",category);
		return "add_category";
		
	}
	categoryService.saveCategory(category);
	return "redirect:/add_category?success";
}
@GetMapping("/show_all_categories")
public String showAllCategories(Model model) {
	List<Category>categories = categoryService.findAllCategories();
	model.addAttribute("categories",categories);
	return "show_all_categories";
}
@DeleteMapping("/show_all_categories")
public String deleteCategory() {
	return "redirect:/add_category?success";
}
}
