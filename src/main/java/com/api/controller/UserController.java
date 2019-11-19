package com.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.AuthenticationRequest;
import com.api.dto.AuthenticationResponse;

import com.api.model.User;
import com.api.exception.ExceptionResponse;
import com.api.service.UserService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

		
		@Autowired private UserService userServ;
		
		final static Logger logger = LoggerFactory
				.getLogger(UserController.class);
		
		 //this method enables the user to login into the application
		 @RequestMapping(value = "/auth", method = RequestMethod.POST)
		    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest)  {
			 
			 User user=null;
		
			 
		     try {
		    	    user = userServ.authenticate(authenticationRequest.getUserId());
		    	  //check if the userId exists
		    	    if(user!=null) {
		    	    	// check if the password is correct
		    	    	if(user.getPassword().equals(authenticationRequest.getPassword()))
		    	    		 return ResponseEntity.ok(new AuthenticationResponse("success",user));
		    	    	else
		    	    		throw new Exception("pwd not correct");
		    	    }
		    	    else
		    	    	throw new Exception("user not found");
		    	   

		     }  catch (Exception ex){
		            logger.error("Exception"+ ex.getClass());
		            return new ResponseEntity<Object>(
		                    new ExceptionResponse("error","Authentication Failed"),
		                    HttpStatus.BAD_REQUEST);

		     }
		
		    }

}
