package com.api.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.api.controller.UserController;

import com.api.dto.AuthenticationRequest;
import com.api.model.User;
import com.api.service.UserService;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class TestUserController 
{
    @InjectMocks
    UserController userController;
     
    @Mock
    UserService userService;
     
    @Test
    public void testUserAuth() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        User user = new User(1, "firstName", "lastName", "password"); 
        when(userService.authenticate(1)).thenReturn(user);
         
     
        AuthenticationRequest authenticationRequest = new AuthenticationRequest (1,"password") ; 
		ResponseEntity<?> responseEntity = userController.authenticate(authenticationRequest);
         
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}
