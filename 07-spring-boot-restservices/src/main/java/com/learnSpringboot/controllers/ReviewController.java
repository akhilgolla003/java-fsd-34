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

import com.learnSpringboot.models.Review;
import com.learnSpringboot.services.ReviewService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping
	public void createReview(@RequestBody Review review) {
		
		log.info("Review Comntroller :: createReview");
		reviewService.createReview(review);
	}
	
	@GetMapping("{id}")
	public Review getReview(@PathVariable Long id) {
		
		return reviewService.getReviewById(id);
	}
	
	@PutMapping("{id}")
	public Review UpdateReview(@PathVariable Long id, @RequestBody Review review) {
		
		return reviewService.updateReview(id, review);
	}
	
	@DeleteMapping("{id}")
	public void deleteReview(@PathVariable Long id) {
		
		 reviewService.deleteReview(id);
	}

}
