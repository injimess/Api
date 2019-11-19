package com.api.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int accountId ; 
	private float balance ;
	@OneToMany(targetEntity = Transaction.class,cascade = {CascadeType.ALL})
	 private List<Transaction>transactions;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public List<Transaction> getTransaction() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	} 
	


}
