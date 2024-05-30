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

import com.learnSpringboot.models.Product;
import com.learnSpringboot.services.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	private void createProduct(@RequestBody Product product) {
		
		/*
		 * 
		 * {
				  "id": 0,
				  "name": "Iphon15",
				  "price": 75000,
				  "quantity": 10,
				  "description": "Iphone Devices",
				  "category": {
				         "id":1
						}
			}
		 */
		log.info("productController :: createProduct");
		productService.createProduct(product);
		
	}
	
	@GetMapping("{id}")
	public Product getProductById(@PathVariable(value = "id") Long ProductId) {
		
		return productService.findProductById(ProductId);
	}
	
	@PutMapping("{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		
		return productService.updateProduct(id, product);
	}
	
	@DeleteMapping("{id}")
	public void deleteProduct(@PathVariable Long id) {
		
		 productService.deleteProduct(id);;
	}
}
