package com.learnSpringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnSpringboot.models.Category;
import com.learnSpringboot.services.CategoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/categories")
@Slf4j
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public void createCategory(@RequestBody Category category) {
		log.info("categoryController :: createCategory");
		categoryService.createCategory(category);
		
	}
	
	@GetMapping("{id}")
	public Category retriveCategoryById(@PathVariable Long id) {
		
		return categoryService.retrieveCategoryById(id);
	}
	
	@PutMapping("{id}")
	public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
		
		return categoryService.updateCategory(id, category);
	}
	
	@DeleteMapping("{id}")
	public void deleteCategory(@PathVariable Long id) {
		
		categoryService.deleteCategory(id);
	}

}
