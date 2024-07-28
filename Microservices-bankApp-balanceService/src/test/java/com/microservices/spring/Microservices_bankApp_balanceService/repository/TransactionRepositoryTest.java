package com.microservices.spring.Microservices_bankApp_balanceService.repository;

import static org.junit.jupiter.api.Assertions.*;

//import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

//import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.microservices.spring.Microservices_bankApp_balanceService.entity.Transaction;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class TransactionRepositoryTest {

	@Autowired
	TransactionRepository transactionRepository;
	
	@BeforeEach
	public void setup() {
		List<Transaction> transactions= new ArrayList<>();
		
		Transaction transaction = new Transaction("e4c5a2e1-5df6-4680-a2e9-8cc000ooo7c7", 9,"deposit","2024-07-11",6000,240000);
		transactions.add(transaction);
		transaction = new Transaction("e4c5a2e1-5df6-4680-a2e9-8cc000ppl7c7", 9,"deposit","2024-07-11",900,48000);
		transactions.add(transaction);
		transactionRepository.saveAll(transactions);
	}

	@Test
	public void testfindByCustomerId() {
		
		List<Transaction> transactions = transactionRepository.findByCustomerId(9);
		assertEquals(2 ,transactions.size() );
		
	}

}
