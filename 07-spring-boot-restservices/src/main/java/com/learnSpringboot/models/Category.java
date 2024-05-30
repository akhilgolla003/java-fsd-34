package com.learnSpringboot.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	
	/*
	 * This class behaves as parent class
	 * 
	 * when we retrieve product info, it calls category info, again category calls list of products and so on...
	 * this leads to stack-over flow error
	 * 
	 * to avoid this, we need to use @JsonIgnore here, then it wont read List of products,
	 * just ignores(will not execute) the field
	 */
	@OneToMany(mappedBy = "category")
	@JsonIgnore
	private List<Product> products;
	
	

}
