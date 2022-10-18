package com.martina.onlinestore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martina.onlinestore.model.Category;
import com.martina.onlinestore.repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public void saveCategory(Category category) {
		categoryRepository.save(category);
	}
	@Override
	public List<Category> findAllCategories() {
		List<Category> categories = categoryRepository.findAll();
		return categories;
	}
	@Override
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
	@Override
	public Category findByCategoryName(String categoryName) {
		Category category = categoryRepository.findByCategoryName(categoryName);
		return category;
	}
	@Override
	public Category findCategoryById(Long id) {
		Optional<Category> optional = categoryRepository.findById(id);
		Category category = null;
		if(optional.isPresent()) {
			category = optional.get();
		}
		else {
			throw new RuntimeException("Category not found");
		}
		return category;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
