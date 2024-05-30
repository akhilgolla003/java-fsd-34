package com.learnSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnSpringboot.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

}
