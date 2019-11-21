package com.api.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.User; 

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUserId(Integer userId) ; 
	public User findByFirstName(String firstName) ; 

	
}
