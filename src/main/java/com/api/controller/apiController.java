package com.api.controller;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Account;
import com.api.model.Transaction;
import com.api.model.User;
import com.api.service.AccountService;
import com.api.service.TransactionService;
import com.api.service.UserService;



@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class apiController {
	
	@Autowired AccountService accountServ ; 
	@Autowired UserService userServ ; 
	@Autowired TransactionService transactionServ ; 
	
	//Get Api to show user informations
	@GetMapping("/user/{userId}")
	public User getInformation(@PathVariable("userId") Integer userId) {
		User currentUser = new User() ; 
		currentUser=userServ.findUser(userId) ; 
		return currentUser ; 
		 
	}
	
	//Post Api that creates new account for the user
	@PostMapping(value = "/user/{userId}/{initialCredit}" , produces = "application/json")
	public StringResponse InitialiseAccount(@PathVariable("initialCredit") Integer initialCredit,@PathVariable("userId") Integer userId) throws Exception {
		
		User currentUser = new User() ; 
		currentUser=userServ.findUser(userId) ; 
		String response = "Your account has been created successfully " ; 
		
		
		try {
			
			if(initialCredit!= 0 ) {
				
				Transaction newTransaction = new Transaction() ; 
				ArrayList<Transaction> transactions = new ArrayList<>() ; 
				Account newAccount = new Account() ; 
				
				
				List<Account> accounts =currentUser.getAccounts(); 
				
				
				newTransaction.setAmmount(initialCredit); 
				transactionServ.save(newTransaction) ; 
				transactions.add(newTransaction) ; 
				
				newAccount.setBalance(initialCredit); 
				newAccount.setTransactions(transactions);
				accountServ.save(newAccount) ; 
				accounts.add(newAccount) ; 
				
				currentUser.setAccounts(accounts);
				userServ.save(currentUser) ; 
				
				
				String res = response+"with "+initialCredit ;
				StringResponse s = new StringResponse(res);
				return s; 
			}
			
			else {
				Account newAccount = new Account() ; 
				newAccount.setBalance(0); 
				accountServ.save(newAccount) ;  
				List<Account> accounts =currentUser.getAccounts();
				accounts.add(newAccount) ; 
				currentUser.setAccounts(accounts) ; 
				userServ.save(currentUser) ; 
				StringResponse s = new StringResponse(response);
				return s ; 
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace() ; 
			
		}
		return null ; 
			
	}
}
