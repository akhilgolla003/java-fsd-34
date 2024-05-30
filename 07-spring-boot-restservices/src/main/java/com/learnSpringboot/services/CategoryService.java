package com.learnSpringboot.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSpringboot.exception.ResourceNotFoundException;
import com.learnSpringboot.models.Category;
import com.learnSpringboot.repository.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void createCategory(Category category) {
		
		log.info("categoryService :: createCategory",category.getName());
		categoryRepository.save(category);
		log.info("category inserted successfully into DB");
	}
	
	public Category retrieveCategoryById(Long id) {
		
		return categoryRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Category Not Found!"));
	}
	
	
	public Category updateCategory(Long id, Category category) {
		
		return categoryRepository.findById(id).map(obj->{
			
			obj.setName(category.getName());
			return categoryRepository.save(obj);
		}).orElseThrow(()-> new ResourceNotFoundException("Category Not Found!"));
	}
	
	public void deleteCategory(Long id) {
		
		if(categoryRepository.findById(id).isPresent())
			categoryRepository.deleteById(id);
		else
			throw new ResourceNotFoundException("Category not Found");
		
	}

}
