package com.learnSpringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.learnSpringboot.models.User;
import com.learnSpringboot.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {
		
		log.info("userService :: createUser {}",user.getUsername());
		userRepository.save(user);
		log.info("user successfully saved in DB");
		
	}
	
	public List<User> fetchAllUsers(){
		
		log.info("userService :: fetchAllUsers");
		return userRepository.findAll();
		
	}
	
	public User findUserById(Long userId) {
		log.info("userService :: findUserById", userId);
		return userRepository.findById(userId)
				.orElseThrow(()->new EntityNotFoundException("User Not Found!"));
	}
	
	public User updateUser(Long userId, User inputUser) {
		
		log.info("userService :: updateUser",userId);
		return userRepository.findById(userId).map(obj-> {
				obj.setEmail(inputUser.getEmail());
				obj.setPassword(inputUser.getPassword());
				obj.setUsername(inputUser.getUsername());
				return userRepository.save(obj);
				}).orElseThrow(()->new EntityNotFoundException("User Not Found!"));
	}
	
	public void deleteUser(Long userId) {
		
		if(userRepository.existsById(userId)) {
			log.info("userService :: deleteUser",userId);
			userRepository.deleteById(userId);
		}else {
			throw new EntityNotFoundException("User Not Found!");
		}
	}

}
