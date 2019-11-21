package com.api.model;



import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	private Integer userId ; 
	private String firstName ; 
	private String lastName ; 
	private String password ; 
	@OneToMany(targetEntity = Account.class,cascade = {CascadeType.ALL})
	private List<Account> accounts;
	
	
	public User() {}
	
	public User(String string, String string2, String string3) {
		super() ; 
		this.firstName = string ; 
		this.lastName = string2 ; 
		this.password = string3 ; 
		
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	} 
	
	

	
	


	


}
