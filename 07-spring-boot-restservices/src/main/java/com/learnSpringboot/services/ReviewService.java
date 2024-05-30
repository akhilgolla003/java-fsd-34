package com.learnSpringboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSpringboot.exception.ResourceNotFoundException;
import com.learnSpringboot.models.Review;
import com.learnSpringboot.repository.ReviewRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	public void createReview(Review review) {
		log.info("Review service :: createReview");
		reviewRepository.save(review);
		log.info("**Review Inserted Successfully**");
	}
	
	public Review getReviewById(Long id) {
		return reviewRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Riview Not Found!"));
	}
	
	public Review updateReview(Long id, Review review) {
		
		Optional<Review> theReview = reviewRepository.findById(id);
		if(theReview.isPresent()) {
			theReview.get().setComment(review.getComment());
			return reviewRepository.save(theReview.get());
		}else {
			throw new ResourceNotFoundException("Review Not Found!");
		}
	}
	
	public void deleteReview(Long id) {
		
		
		if(reviewRepository.findById(id).isPresent()) {
			
			reviewRepository.deleteById(id);
			
		}else {
			throw new ResourceNotFoundException("Review Not Found!");
		}
	}
}
