package com.api.dto;

import java.io.Serializable;


public class AuthenticationRequest implements Serializable{
	
	private static final long serialVersionUID = 3937497075151274954L;
	
		private Integer  customerId;
	    private String password;

	    public AuthenticationRequest() {
	        super();
	    }

	    public AuthenticationRequest(Integer customerId, String password) {
	        this.setCustomerId(customerId);
	        this.setPassword(password);
	    }

	   
	  

	    public Integer  getCustomerId() {
			return this.customerId;
		}

		public void setCustomerId(Integer  customerId) {
			this.customerId = customerId;
		}

		public String getPassword() {
	        return this.password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
	}


