package com.learnSpringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnSpringboot.models.User;
import com.learnSpringboot.repository.UserRepository;
import com.learnSpringboot.services.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping
	public void createUser(@RequestBody User user) {
		
		log.info("UserController :: createUser",user.getUsername());
		userService.createUser(user);
		
	}
	
	@GetMapping("{id}")
	public User getUserById(@PathVariable(value = "id") Long userId) {
		
		log.info("userController :: getUserById");
		return userService.findUserById(userId);
	}
	
	@PutMapping("{userId}")
	public User updateUser(@PathVariable Long userId, @RequestBody User user) {
		
		log.info("userController :: updateUser", userId);
		return userService.updateUser(userId, user);
	}
	
	@DeleteMapping("{userId}")
	public void deleteUser(@PathVariable Long userId) {
		
		log.info("userController :: deleteUser", userId);
		userService.deleteUser(userId);
	}
	
	
	
	
	//DSL - 
	@GetMapping("{username}/{email}")
	public User getUserByEmail(@PathVariable String username, @PathVariable String email) {
		return userRepository.findByUsernameAndEmail(username,email);
	}
	
	@GetMapping("{username}/{password}")
	public User getUserByEmailAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username,password);
	}
	
	//pathvariables are optional
	@GetMapping
	public User getUserByUsername(@RequestParam String username) {
		return userRepository.findByUsername(username);
	}

}
