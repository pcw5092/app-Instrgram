package org.Instrgram.repository;

import org.Instrgram.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	// select * from user where username= 1?
	User findByUsername(String username);

}
