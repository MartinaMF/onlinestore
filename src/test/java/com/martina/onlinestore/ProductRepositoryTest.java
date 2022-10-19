package com.martina.onlinestore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.martina.onlinestore.model.Admin;
import com.martina.onlinestore.model.Category;
import com.martina.onlinestore.model.Product;
import com.martina.onlinestore.repository.ProductRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProductRepositoryTest {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private TestEntityManager entityManager;
	@Test
	public void saveProductTest() {
		Admin admin = entityManager.find(Admin.class, 1);
		Category category = entityManager.find(Category.class, 4);
		Product product = new Product();
		product.setAdmin(admin);
		product.setCategory(category);
		product.setDescription("product description");
		product.setName("kids jewlery");
		product.setPrice(13);
		product.setProductId((long)20);
		product.setImage("image");
		product.setQuantity(30);
		product.setQuantityOrdred(2);
		Product savedProduct = productRepository.save(product);
		assertTrue(savedProduct.getProductId() > 0);
		
	}
	/*
	@Test
	public void findProductByIdTest() {
		Admin admin = entityManager.find(Admin.class, 1);
		Category category = entityManager.find(Category.class,4);
		Product product = new Product((long)20, "dimond ring", 100,"description", 10, 20,"image",admin,category);
		entityManager.persist(product);
		Product foundProduct = productRepository.findById(product.getProductId()).get();
		assertThat(foundProduct).isEqualTo(product);
	}
	*/

}
