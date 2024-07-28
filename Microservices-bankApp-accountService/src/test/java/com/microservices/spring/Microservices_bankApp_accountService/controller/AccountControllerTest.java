package com.microservices.spring.Microservices_bankApp_accountService.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.spring.Microservices_bankApp_accountService.Entity.Account;
import com.microservices.spring.Microservices_bankApp_accountService.service.AccountService;

@WebMvcTest(AccountController.class)
class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AccountService accountService;
	
	@MockBean
	private Account account;
	
	 @BeforeEach
	    public void setUp() {
	        account = new Account();
	        
	    }
//     @Test
//	    public void testCreateAccount_success() throws Exception{
//		 account = new Account( 7,324241789 , "savings","345,new delhi","Bank of India","2024-07-09");    
////	        
////		  //account = new Account( 7,324241789 , "savings","345,new delhi","Bank of India","2024-07-09");    
////	        
//	when(accountService.saveAccount(account)).thenReturn(account);
////		// when(accountService.saveAccount(any(Account.class))).thenReturn(account);
////		// Account result = accountService.saveAccount(account);
////		 //ResponseEntity<String> response = accountService.saveAccount(account);
//////		 ResponseEntity<String> response1 = new ResponseEntity<>("User Account successfully created....",HttpStatus.CREATED);
//////		 
//////		 System.out.println(response1+"\n **///***");
//////		 
////		 System.out.println(account+" **(**((");
////	 
//    mockMvc.perform(post("/account/createAccount")
//                .contentType("application/json")
//                .content(asJsonString(account)))
//	    .andExpect(status().isCreated())
//        .andExpect(content().string("User Account successfully created...."));
//
////	    
//   verify(accountService, times(1)).saveAccount(any(Account.class));
////
//	 }
////	    @Test
////	    public void testCreateAccount_success() throws Exception{
////	        when(accountService.saveAccount(account)).thenReturn(account);
//	       // when(accountService.saveAccount(account)).thenReturn(new ResponseEntity<>("User Account successfully created....",HttpStatus.CREATED));
//
////	        mockMvc.perform(post("/account/createAccount")
////	                .contentType(MediaType.APPLICATION_JSON)
////	                .content(asJsonString(account)))
////	                .andExpect(status().isCreated())
////	                .andExpect(content().string("User Account successfully created...."))
////	                .andDo(print());
//	 
////	 .content("{\"accountNumber\":324241789,\"customerId\":7,\"accountType\":\"savings\" , \"branchAddress\":\"345,new delhi\",\"bankName\":\"Bank of India\",\"createDt\":\"2024-07-09\" }"))
////	    }

	    @Test
	    public void testGetAccountDetails() throws Exception {
	    	// account = new Account( 7,324241789 , "savings","345,new delhi","Bank of India","2024-07-09");    
	    	account = new Account( 7,324241789 , "savings","345,new delhi","Bank of India","2024-07-09");    
	           
	        when(accountService.getAccount(7)).thenReturn(account);

	        mockMvc.perform(get("/account/getAccount/7")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.accountNumber").value(324241789))
	                .andExpect(jsonPath("$.accountType").value("savings"))
	                .andExpect(jsonPath("$.bankName").value("Bank of India"))
	                .andExpect(jsonPath("$.branchAddress").value("345,new delhi"))
	                .andDo(print());
	    }

	    private static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	

}
