package com.api.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.api.dao.UserRepository;

import com.api.model.User;

@Service
@Transactional
public class UserService {
	
	@Autowired UserRepository userRepo ; 
	
	public User authenticate (Integer customerId) {
		User user = null; 
		try {

			user = userRepo.findByCustomerId(customerId) ; 
			if(user !=null)
			System.out.println("user" + user) ; 
			else 
				System.out.println("user is null") ; 
		}
		catch(Exception e) {
			System.out.println("An error occured when authentificating" + e.getMessage()) ; 
		}
		
		return user ; 
	}
	
	
	public User save(User user) {
		
		return userRepo.save(user) ; 
	}
	
	public User findUser(Integer customerId) {
		
		return userRepo.findByCustomerId(customerId) ; 
	}



}

