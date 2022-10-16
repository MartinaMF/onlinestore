package com.martina.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.martina.onlinestore.model.Category;
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository <Category,Long>{
 Category findByCategoryName(String name);
}
