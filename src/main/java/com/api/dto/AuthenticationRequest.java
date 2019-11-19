package com.api.dto;

import java.io.Serializable;


public class AuthenticationRequest implements Serializable{
	
	private static final long serialVersionUID = 3937497075151274954L;
	
		private Integer  userId;
	    private String password;

	    public AuthenticationRequest() {
	        super();
	    }

	    public AuthenticationRequest(Integer userId, String password) {
	        this.setUserId(userId);
	        this.setPassword(password);
	    }

	   
	  

	    public Integer  getUserId() {
			return this.userId;
		}

		public void setUserId(Integer  userId) {
			this.userId = userId;
		}

		public String getPassword() {
	        return this.password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
	}


