package com.learnSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnSpringboot.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

	//fetch data - Based on the non-primary keys - use DSL
		//DSL : Domain Specific Language.
		//while writing should follow grammar syntax - method names
		
		
		//select * from table where username='munna';
		
		//select * from table where username='munna' and password='12345';
		
		//select * from table where email='munna';
		
		//select * from table order by price asc/desc;
		
	
	// at application startup- spring-boot validates
	User findByUsername(String ussername);
	
	User findByUsernameAndPassword(String username, String password);
	
	User findByEmail(String email);
	
	User findByUsernameAndEmail(String username, String emial);
	
	User findByUsernameOrEmail(String username, String emial);
	
	
	
}
