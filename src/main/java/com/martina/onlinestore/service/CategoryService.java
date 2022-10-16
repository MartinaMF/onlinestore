package com.martina.onlinestore.service;

import java.util.List;
import com.martina.onlinestore.model.Category;

public interface CategoryService {
	void saveCategory(Category category);
	List<Category> findAllCategories();
	Category findByCategoryName(String categoryName);
	public void deleteCategory(Long id);
}
