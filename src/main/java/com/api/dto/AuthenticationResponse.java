package com.api.dto;
import java.io.Serializable;

import com.api.model.User;

public class AuthenticationResponse implements Serializable{

	private static final long serialVersionUID = -488282197368496803L;

		private final String message;
	    
	    User user;

	    public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public AuthenticationResponse(String msg,User user) {
	        this.message=msg;
	        this.user=user;
	    }

	    public String getMessage() {
			return message;
		}

	}
