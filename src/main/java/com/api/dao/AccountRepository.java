package com.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	
}
