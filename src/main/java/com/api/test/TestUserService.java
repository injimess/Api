package com.api.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.api.dao.UserRepository;
import com.api.model.User;
import com.api.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class TestUserService {
	
	@InjectMocks
	UserService userService ; 
	
	@Mock
	UserRepository userRepository ;
	
	@Mock
	User user;
	
	@Test
	public void getUser() {
		
		User user = new User(1,"firstname" , "lastname" , "password") ; 
		
		when(userRepository.save(user)).thenReturn(user) ; 
		User userTested = userService.save(user) ; 
		
		assertThat(userTested.getPassword()).isEqualTo("password") ; 
		verify(userRepository,times(1)).save(user) ; 
		
	}

}
