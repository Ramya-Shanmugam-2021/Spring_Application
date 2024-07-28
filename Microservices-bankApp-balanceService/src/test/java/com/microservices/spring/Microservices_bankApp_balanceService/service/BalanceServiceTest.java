package com.microservices.spring.Microservices_bankApp_balanceService.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.microservices.spring.Microservices_bankApp_balanceService.entity.Balance;
import com.microservices.spring.Microservices_bankApp_balanceService.entity.Transaction;
import com.microservices.spring.Microservices_bankApp_balanceService.model.BalanceMapper;
import com.microservices.spring.Microservices_bankApp_balanceService.repository.BalanceRepository;
import com.microservices.spring.Microservices_bankApp_balanceService.repository.TransactionRepository;

@SpringBootTest
class BalanceServiceTest {

	@InjectMocks
	BalanceService balanceService;
	
	@Mock
	BalanceRepository balanceRepository;
	
	@Mock
	TransactionRepository transactionRepository;
	
	@BeforeEach
	public void setup() {
		Balance balanceNew = new Balance();
		Transaction transaction = new Transaction();
		
	}
	
	@Test
	public void testGetBalance() {
		//when()
		BalanceMapper balanceMapper =null;
		double result = balanceService.getBalance(balanceMapper);
	}

}
