package com.api.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.TransactionRepository;
import com.api.model.Transaction;

@Service
@Transactional
public class TransactionService {
	
	@Autowired TransactionRepository transactionRepo ; 
	
	public TransactionService(TransactionRepository transactionRepo) {
		
		this.transactionRepo = transactionRepo ; 
	}
	
	public Transaction save(Transaction transaction) {
		
		return transactionRepo.save(transaction) ; 
	}

}



