package com.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction , Integer> {

}

