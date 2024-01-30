package org.work.springbootwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work.springbootwork.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product> findByCategoryId(Long categoryId);
    List<Product> findByNameContaining(String name);
}
