package com.learnSpringboot.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private double price;
	private Integer quantity;
	private String description;
	private boolean inStock;
	private String barCode;
	
	
	/*
	 * This class behaves as child class since it has @ManyToOne
	 * 
	 * where ever u see @ManyToOne that class behaves as child class, there u can create a foreign key(@JoinTable)
	 * 
	 * automatically, category-id will be taken as foreign key for this class
	 * 
	 * whenever someone enters product data without category, it throws exception - nullable-false (avoids data inconsistency)
	 * 
	 * before proving category, should make sure that should be availble in category table,
	 * 	otherwise it throws an error. so first insert category, then product info
	 */
	@ManyToOne
	@JoinColumn(name = "cat_id",nullable = false)
	private Category category;
	
	
	
	/*
	 * 
	 * {
  "id": 0,
  "name": "string",
  "price": 0,
  "quantity": 0,
  "description": "string",
  "inStock": true,
  "barCode": "string",
  "category": {
    "id": 0,
    "name": "string"
  },
  "reviews": [
    {
      "id": 0,
      "comment": "string",
      "product": "string"
    }
  ]
}
	 */
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Review> reviews;
	
	

}
