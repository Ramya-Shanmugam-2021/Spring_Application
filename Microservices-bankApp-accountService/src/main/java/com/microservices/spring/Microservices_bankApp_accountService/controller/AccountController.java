package com.microservices.spring.Microservices_bankApp_accountService.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.spring.Microservices_bankApp_accountService.Entity.Account;
import com.microservices.spring.Microservices_bankApp_accountService.exception.ResourceNotFoundException;
//import com.microservices.spring.Microservices_bankApp_accountService.exception.ResourceNotFoundException;
//import com.microservices.spring.Microservices_bankApp_accountService.feign.Transaction;
import com.microservices.spring.Microservices_bankApp_accountService.model.AccountMapper;
import com.microservices.spring.Microservices_bankApp_accountService.model.Customer;
import com.microservices.spring.Microservices_bankApp_accountService.service.AccountService;
//import com.microservices.spring.Microservices_bankApp_cardService.exception.NoAmountInAccountException;
import com.microservices.spring.Microservices_bankApp_accountService.model.Transaction;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	//creating account
	@PostMapping("/createAccount")
	public ResponseEntity<String> createAccountForUser(@RequestBody Account account){
		return accountService.saveAccount(account);   
	}
	
	//getting account details by user id - single account
	@GetMapping("/getAccount/{customerId}")
	public Account getAccountDetails(@PathVariable int customerId){
		
		return accountService.getAccount(customerId);
		
	}	
	
	@GetMapping("/getTransactionInfo/{customerId}")
	public List<Transaction> getTransactionbyUserId(@PathVariable int customerId){
		return accountService.getTransactionbyUserId(customerId);
	}				


	//getting all users details with account details
	@GetMapping("/getAllUsers")
	public List<AccountMapper> getAllUsersDetails(){
		
		return accountService.getAllUsers();
		
	}
	
	@GetMapping("/getUsersAccount/{id}")
	public AccountMapper getOneUsersData(@PathVariable int id) {
		return accountService.getOneUsersData(id);
	}
	
	

	@PutMapping("/updateCustomer/{customerId}")
    public Customer updateCustomer(@PathVariable int customerId,@RequestBody Customer customer) {
        return accountService.updateCustomer(customerId,customer);
		
	}
	
//	@DeleteMapping("/removeInfo/{customerId}")
//	public ResponseEntity<String> deleteInfoById(@PathVariable int customerId) {
//		
//		return accountService.deleteInfoById(customerId);
//	}
//	
	
}	
//		Employee updateEmployee = employeeRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
//
//        updateEmployee.setFirstName(employeeDetails.getFirstName());
//        updateEmployee.setLastName(employeeDetails.getLastName());
//        updateEmployee.setEmailId(employeeDetails.getEmailId());
//
//        employeeRepository.save(updateEmployee);
//
//        return ResponseEntity.ok(updateEmployee);
    
//	@PatchMapping(/)
//	
//	
//	@PutMapping("/alterUserData/{id}")
//	public 


///
