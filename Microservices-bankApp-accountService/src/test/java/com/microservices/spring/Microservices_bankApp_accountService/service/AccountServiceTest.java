package com.microservices.spring.Microservices_bankApp_accountService.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
//import java.util.Date;
import java.util.List;

//import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.microservices.spring.Microservices_bankApp_accountService.Entity.Account;
import com.microservices.spring.Microservices_bankApp_accountService.exception.ResourceNotFoundException;
import com.microservices.spring.Microservices_bankApp_accountService.feign.BalanceTrancactionInterface;
import com.microservices.spring.Microservices_bankApp_accountService.model.Transaction;
import com.microservices.spring.Microservices_bankApp_accountService.repository.AccountRepository;

@SpringBootTest
public class AccountServiceTest {

	@InjectMocks
	AccountService accountService;
	
	@Mock
	AccountRepository accountRepository;
	
	@Mock
	Account account;
	
	@Mock
	Transaction transaction;
	
	@Mock
	BalanceTrancactionInterface balanceTrancactionInterface;
	
	
	 @BeforeEach
	    void setUp() {
      account = new Account( 1,324241718 , "savings","345,new delhi","Bank of India","2024-07-09");    
	    }
	
	@Test
	public void getAccountTest() {
		when(accountRepository.findByCustomerId(1)).thenReturn(account);
		Account testedAccount = accountService.getAccount(1);
		assertEquals(testedAccount ,account );
	}

	 @Test
	  public void testSaveAccount_success() {
	        when(accountRepository.save(account)).thenReturn(account);
	        ResponseEntity<String> response = accountService.saveAccount(account);
	        assertNotNull(response);
	        assertEquals(HttpStatus.CREATED, response.getStatusCode());
	        assertEquals("Created your account successfully", response.getBody());
	    }

	 @Test
	 public void testSaveAccount_failure() {
		 when(accountRepository.save(account)).thenThrow(new RuntimeException("Error occured in Account Service.!."));
		 ResponseEntity<String> response = accountService.saveAccount(account);
		 
		 assertNotNull(response);
		 assertEquals(HttpStatus.INTERNAL_SERVER_ERROR , response.getStatusCode());
		 assertEquals("Error occured in Account Service.!.",response.getBody());
	 }

	 @Test
	    public void testGetTransactionbyUserId_success() {
		 Transaction transaction1 = new  Transaction("164a8768-8a08-4379-a60d-1f3a96149034",2,"deposit","2024-07-11",
	    		  60000,240000 );
	      Transaction transaction2 = new  Transaction("184a8799-8a08-4379-65yd-1f3a96187656",2,"deposit","2024-07-11",
	    		  60000,7000 );
	 
	  List<Transaction> transactions = Arrays.asList(transaction1, transaction2);
	  when(balanceTrancactionInterface.getTransactionbyUserId(2)).thenReturn(transactions);
	  List<Transaction> response = accountService.getTransactionbyUserId(2);
	  
	  assertEquals(2,response.size() );
	  assertEquals("164a8768-8a08-4379-a60d-1f3a96149034", response.get(0).getTransactionId());
}
	 
	 @Test
	 public void testGetTransactionbyUserId_failiure() {
           when(balanceTrancactionInterface.getTransactionbyUserId(3)).thenThrow(new ResourceNotFoundException("No data found for your id.!."));

	       // List<Transaction> result;
	        		accountService.getTransactionbyUserId(2);

//	        assertNull(result);
//	        assertEquals(Collections.emptyList(), result);
	        		}
	 
}