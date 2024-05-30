package com.learnSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnSpringboot.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
