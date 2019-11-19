package com.api.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.AccountRepository;
import com.api.model.Account;

@Service
@Transactional
public class AccountService {

	@Autowired AccountRepository accountRepo ; 
	
	public AccountService(AccountRepository accountRepo) {
		
		this.accountRepo = accountRepo ; 
	}
	
	public Account save(Account account) {
		
		return accountRepo.save(account) ; 
	}
	
}
