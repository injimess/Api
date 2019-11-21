package com.api.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.dao.UserRepository;
import com.api.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthTestUserRepository {
	
	@Autowired
	private TestEntityManager entityManger;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test 
	public void testFindUser () throws Exception {
		User userM = new User("firstname", "lastname", "password") ; 
		this.entityManger.persist(userM);
		User user = this.userRepository.findByFirstName("firstname");
		assertThat(user.getFirstName()).isEqualTo("firstname");
		assertThat(user.getPassword()).isEqualTo("password");
		
	}
	

}
