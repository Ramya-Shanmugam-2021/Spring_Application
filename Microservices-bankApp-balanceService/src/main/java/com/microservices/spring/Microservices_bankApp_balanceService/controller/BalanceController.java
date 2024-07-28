package com.microservices.spring.Microservices_bankApp_balanceService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.spring.Microservices_bankApp_balanceService.entity.Balance;
import com.microservices.spring.Microservices_bankApp_balanceService.entity.Transaction;
import com.microservices.spring.Microservices_bankApp_balanceService.exception.ResourceNotFoundException;
import com.microservices.spring.Microservices_bankApp_balanceService.model.BalanceMapper;
import com.microservices.spring.Microservices_bankApp_balanceService.service.BalanceService;

@RestController
@RequestMapping("/balance")
public class BalanceController {
	
	 @Autowired
	  private BalanceService balanceService;
	
	@PostMapping("/transactions/deposit")
	public ResponseEntity<String> getBalanceWhenDeposit(@RequestBody BalanceMapper balanceMapper) {
		
		try {
		Double totalBalance = balanceService.getBalance(balanceMapper);
		return new ResponseEntity<>("Amount deposited successfully. Total balance is : "+totalBalance,HttpStatus.OK);
		}
		catch(Exception ex) {
			throw new RuntimeException("Exception occured in balance service");
		}
	}
	
	@PostMapping("/transactions/withdraw")
	public ResponseEntity<String> getBalanceWhenWithdraw(@RequestBody BalanceMapper balanceMapper) {
		try {
		return balanceService.getBalanceWhenWithdraw(balanceMapper);
		}
		catch(Exception ex) {
			throw new RuntimeException("Exception occured in balance service");
		}
	}
	
	@GetMapping("/getTransactionInfo/{customerId}")
	public List<Transaction> getTransactionbyUserId(@PathVariable int customerId){
		System.out.println(" i am from BalanceController in balance service \n ***///");
		List<Transaction> transactions = null;
		try {
			transactions = balanceService.getTransactionbyUserId(customerId);
			if(transactions.isEmpty()) {
				throw new ResourceNotFoundException("error");
			}
		}catch(ResourceNotFoundException ex) {
			throw new ResourceNotFoundException("Transactions not available for the id");
		}
		catch(Exception ex) {
			throw new RuntimeException("Error occured in service...");
		}
		return  transactions;
	}
	
	
}

//import java.util.UUID;
//
//public class TransactionService {
//
//    public String generateTransactionId() {
//        return UUID.randomUUID().toString();
//    }
//
//    // Other service methods
//}


//@PostMapping("/contact")
//public Contact saveContactInquiryDetails(@RequestBody Contact contact) {
//    contact.setContactId(getServiceReqNumber());
//    contact.setCreateDt(new Date(System.currentTimeMillis()));
//    return contactRepository.save(contact);
//}
//
//public String getServiceReqNumber() {
//    Random random = new Random();
//    int ranNum = random.nextInt(999999999 - 9999) + 9999;
//    return "SR"+ranNum;
//}