package com.martina.onlinestore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.martina.onlinestore.model.Admin;
import com.martina.onlinestore.model.Category;
import com.martina.onlinestore.repository.CategoryRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoryRepositoryTest {
@Autowired
private CategoryRepository categoryRepo;
@Autowired
private TestEntityManager entityManager;
@Test
public void testsaveCategory() {
	Admin admin = entityManager.find(Admin.class, 1);
	Category category = new Category();
	category.setCategoryId((long) 3);
	category.setAdmin(admin);
	category.setCategoryName("chains");
	category.setDescription("chains for women");
	category.setImage("img2");
	
	Category savedCategory = categoryRepo.save(category);
	assertTrue(savedCategory.getCategoryId() > 0);
	
	
}
@Test
public void testCategoryById() {
	Admin admin = entityManager.find(Admin.class, 1);
	Category category = new Category("nickles","description","imag",admin);
	entityManager.persist(category);
	Category foundCategory = categoryRepo.findById(category.getCategoryId()).get();
	 assertThat(foundCategory).isEqualTo(category);
	
	
}
}
