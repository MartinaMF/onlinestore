
package com.martina.onlinestore.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.martina.onlinestore.model.Category;
import com.martina.onlinestore.service.CategoryService;


import jakarta.validation.Valid;

/**
 * perform CRUD operations on category entity
 * @author marti
 *
 */
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
/**
 * Add new category 
 * @param category
 * @param result
 * @param model
 * @return
 */
@PostMapping("/add_category/save")
public String saveCategory(@Valid @ModelAttribute("category")Category category,BindingResult result,Model model) {
	 /*Category existingCategory = categoryService.findByCategoryName(category.getCategoryName());
	 if(existingCategory != null && existingCategory.getCategoryName()!=null && !existingCategory.getCategoryName().isEmpty()) {
		 result.rejectValue("categoryName", null, "there is Category with the same name");
	 }
	if(result.hasErrors()) {
		model.addAttribute("category",category);
		return "add_category";
		
	}*/
	categoryService.saveCategory(category);
	return "redirect:/show_all_categories";
}
/**
 * show list of all existing categories
 * @param model
 * @return
 */
@GetMapping("/show_all_categories")
public String showAllCategories(Model model) {
	List<Category>categories = categoryService.findAllCategories();
	model.addAttribute("categories",categories);
	return "show_all_categories";
}
/**
 * delete category using category id 
 * @param id
 * @return
 */
@RequestMapping(value="/show_all_categories/delete/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
public String deleteCategory(@PathVariable(value="id") Long id) {
	categoryService.deleteCategory(id);
	return "redirect:/show_all_categories?success";
}

/**
 * update category information
 * @param id
 * @param tutorial
 */

@GetMapping("/show_update_form/{id}")
public String updateForm(@PathVariable(value="id") long id,Model model) {
	Category category = categoryService.findCategoryById(id);
	//pre-populate the form with category data
	model.addAttribute("category",category);
	return "update_category";
}


}
