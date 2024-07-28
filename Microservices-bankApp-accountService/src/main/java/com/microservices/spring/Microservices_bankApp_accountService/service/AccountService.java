package com.microservices.spring.Microservices_bankApp_accountService.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import com.microservices.spring.Microservices_bankApp_accountService.Entity.Account;
import com.microservices.spring.Microservices_bankApp_accountService.exception.ResourceNotFoundException;
//import com.microservices.spring.Microservices_bankApp_accountService.controller.Employee;
import com.microservices.spring.Microservices_bankApp_accountService.feign.AccountInterface;
import com.microservices.spring.Microservices_bankApp_accountService.feign.BalanceTrancactionInterface;
import com.microservices.spring.Microservices_bankApp_accountService.model.AccountMapper;
import com.microservices.spring.Microservices_bankApp_accountService.model.Customer;
import com.microservices.spring.Microservices_bankApp_accountService.model.Transaction;
import com.microservices.spring.Microservices_bankApp_accountService.repository.AccountRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.ws.rs.core.Response.Status;


@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountInterface accountInterface;
	
	@Autowired
	private BalanceTrancactionInterface balanceTrancactionInterface;
	
	public ResponseEntity<String> saveAccount(Account account) {
		Account resultAccount = null;
		try {
		account.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));
		resultAccount = accountRepository.save(account);
		}
		catch(Exception ex) {
			 throw new RuntimeException("Error occured in Account Service.!.");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Created your account successfully");
	}

//	public  ResponseEntity<String> saveAccount(Account account) {
//		Account savedAccount = null;
//		ResponseEntity response = null;
//		 
//		try {
//			account.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));
//		
//		   savedAccount = accountRepository.save(account);
//       
//          if (savedAccount.getAccountNumber() > 0) {
//          response = ResponseEntity
//                  .status(HttpStatus.CREATED)
//                  .body("User Account successfully created....");
//          }
//          } catch (Exception ex) {
//            response = ResponseEntity
//              .status(HttpStatus.INTERNAL_SERVER_ERROR)
//              .body("An exception occured due to " + ex.getMessage());
//         }
//     return response;
//}

	public Account getAccount(int customerId) {
		Account accountData = null;
		try {
			accountData = accountRepository.findByCustomerId(customerId);
			if(Objects.isNull(accountData)) {
				throw new ResourceNotFoundException("We can't find the account by your id");
			}
	    }
		catch(ResourceNotFoundException ex) {
		    throw new ResourceNotFoundException(ex.getMessage());
		
	    }
		catch(Exception ex) {
			 throw new RuntimeException("Error occured in Account Service.!.");
		}
		return accountData;
	}

	
	public List<AccountMapper> getAllUsers(){
		List<Account> accounts = accountRepository.findAll();

		List<Customer> customers =  accountInterface.getAllUsers();
		List<AccountMapper> accountMappers = new ArrayList<>();
		
		for(Account account : accounts) {
			Customer customer = customers.get((account.getCustomerId())-1);
			AccountMapper accountMapper = new AccountMapper();
			accountMapper.setName(customer.getName());
			accountMapper.setEmail(customer.getEmail());
			accountMapper.setAccountNumber(account.getAccountNumber());
			accountMapper.setAccountType(account.getAccountType());
			accountMapper.setBranchAddress(account.getBranchAddress());
			accountMapper.setBankName(account.getBankName());
			accountMapper.setCustomerId(account.getCustomerId());
			accountMapper.setMobileNumber(customer.getMobileNumber());
			accountMapper.setAddress(customer.getAddress());
			
			accountMappers.add(accountMapper);
		}
		
		return accountMappers;
	}

	public AccountMapper getOneUsersData(int id) {
		Account account = accountRepository.findByCustomerId(id);
		Customer customer = accountInterface.getUserById(id);
		AccountMapper accountMapper = new AccountMapper();
		accountMapper.setName(customer.getName());
		accountMapper.setEmail(customer.getEmail());
		accountMapper.setAccountNumber(account.getAccountNumber());
		accountMapper.setAccountType(account.getAccountType());
		accountMapper.setBranchAddress(account.getBranchAddress());
		accountMapper.setCustomerId(account.getCustomerId());
		accountMapper.setBankName(account.getBankName());
		accountMapper.setMobileNumber(customer.getMobileNumber());
		accountMapper.setAddress(customer.getAddress());
		
		return accountMapper;
	}

	@CircuitBreaker(name = "accountService" , fallbackMethod= "accountFallback" )
	public List<Transaction> getTransactionbyUserId(int customerId) {
	
		List<Transaction> resultTransaction = null;
		try {
			resultTransaction =balanceTrancactionInterface.getTransactionbyUserId(customerId);
			if(resultTransaction.isEmpty() || resultTransaction==null ) {
				throw new ResourceNotFoundException("No data found for your id.!.");
			}
		}
		catch(ResourceNotFoundException ex) {
			throw new ResourceNotFoundException(ex.getMessage());
		}
		
		return resultTransaction;
	}
	
	public List<Transaction> accountFallback(Exception e) {
		List<Transaction> resultTransaction =Collections.emptyList();
		if(resultTransaction.isEmpty()) {
			throw new RuntimeException("Balance Service is down");
		}
		 return Collections.emptyList();  // Return an empty list as fallback
	}		
		 
		// System.out.println("I am fallback call while calling transactions from account service");
//		 Transaction transaction = new Transaction();
//		 transaction.setResponse("fallback method ");
//		 List<Transaction> listTr = new ArrayList<>();
//		 listTr.add(transaction);
//		  
		 //we can use *****************************
		// return listTr;

	
//	public String accountFallback(Exception e) {
//		 System.out.println("I am fallback call while calling transactions from account service");
//		 //List<Transaction> listTr = new ArrayList<>();
//		// return listTr;
//		return "I am fallback call while calling transactions from ";
//	}
	
	public Customer updateCustomer(int customerId, Customer customer){
		
		Customer customers =  accountInterface.updateCustomer(customerId,customer);
		
		return customers;

	}		
				//.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id: " + customerId));

		
//		Employee updateEmployee = accountInterface.findByCustomerId(customerId)
//	            .orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id: " + customerId));
//
//	    updateEmployee.setFirstName(employeeDetails.getFirstName());
//	    updateEmployee.setLastName(employeeDetails.getLastName());
//	    updateEmployee.setEmailId(employeeDetails.getEmailId());
//
//	    employeeRepository.save(updateEmployee);
//
//	    return ResponseEntity.ok(updateEmployee);
	}

//	public ResponseEntity<String> deleteInfoById(int customerId) {
//		ResponseEntity<String> response= null;
//		try {
//			response = accountInterface.deleteInfoById(customerId);
//		System.out.println(" 676767 *** "+response);
//		}catch(Exception ex) {
//			response = 	ResponseEntity
//					.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("user is not available in the id : "+customerId);}
//		 return response;
//		
//	}
	




//public EmployeeResponse getEmployeeById(int id) {
//	Employee employee = employeeRepository.findById(id).get();
//	
//	EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
//	
//	ResponseEntity<AddressResponse>  response = addressClient.getAddressByEmployeeId(id);
//	AddressResponse addressResponse = response.getBody();
//	
//	employeeResponse.setAddressResponse(addressResponse);
//	
//	return employeeResponse;