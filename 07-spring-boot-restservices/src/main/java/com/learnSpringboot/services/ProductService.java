package com.learnSpringboot.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSpringboot.exception.ResourceNotFoundException;
import com.learnSpringboot.models.Product;
import com.learnSpringboot.models.Review;
import com.learnSpringboot.repository.ProductRepository;
import com.learnSpringboot.repository.ReviewRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	public void createProduct(Product product) {
		
		log.info("productService :: createProduct {} ",product.getName());
		
		product.setBarCode(UUID.randomUUID().toString());
		product.setInStock(true);
		
		//if u want to convert category data to JSON : ObjectMapper or GoogleJson 
		//store json in which column you require
		
		//for images/files - use blob
		
		productRepository.save(product);
		
//		Review review = new Review();
//		review.setComment(product.getReviews().);
//		reviewRepository.save(null)
		
		log.info("*******",product.getReviews());
		log.info("product inserted successfully!");
	}
	
	
	public Product findProductById(Long productId) {
		
		return productRepository.findById(productId)
				.orElseThrow(()->new ResourceNotFoundException("Product Not Found!"));
	}
	
	public Product updateProduct(Long id, Product product) {
		
		return productRepository.findById(id).map(obj->{
			obj.setName(product.getName());
			obj.setPrice(product.getPrice());
			obj.setCategory(product.getCategory());
			obj.setQuantity(product.getQuantity());
			obj.setInStock(product.isInStock());
			obj.setBarCode(product.getBarCode());
			
			obj.setCategory(product.getCategory());
			return productRepository.save(obj);
		}).orElseThrow(()-> new ResourceNotFoundException("Product Not Found!"));
	}
	
	public void deleteProduct(Long id) {
		
		if(productRepository.findById(id).isPresent()) {
			productRepository.deleteById(id);
		}else {
			
			throw new ResourceNotFoundException("Product Not Found");
		}
	}

}
