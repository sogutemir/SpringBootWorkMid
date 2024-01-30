package org.work.springbootwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work.springbootwork.model.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
