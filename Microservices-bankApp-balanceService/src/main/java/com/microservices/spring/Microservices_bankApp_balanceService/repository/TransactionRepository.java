package com.microservices.spring.Microservices_bankApp_balanceService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.spring.Microservices_bankApp_balanceService.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,String>{

	

	List<Transaction> findByCustomerId(int customerId);

}
