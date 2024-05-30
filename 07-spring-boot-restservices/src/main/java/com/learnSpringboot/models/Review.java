package com.learnSpringboot.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String comment;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST,
			CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "prod_id",nullable = false)
	private Product product;

}
