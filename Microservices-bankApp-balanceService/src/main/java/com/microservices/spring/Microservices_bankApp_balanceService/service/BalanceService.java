package com.microservices.spring.Microservices_bankApp_balanceService.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.spring.Microservices_bankApp_balanceService.entity.Balance;
import com.microservices.spring.Microservices_bankApp_balanceService.entity.Transaction;
import com.microservices.spring.Microservices_bankApp_balanceService.model.BalanceMapper;
import com.microservices.spring.Microservices_bankApp_balanceService.repository.BalanceRepository;
import com.microservices.spring.Microservices_bankApp_balanceService.repository.TransactionRepository;

@Service
public class BalanceService {

	@Autowired
	private BalanceRepository balanceRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public double getBalance(BalanceMapper balanceMapper) {
		
		Optional<Balance> previousBalance = balanceRepository.findById(balanceMapper.getCustomerId());
		//System.out.println(previousBalance);
		Balance balanceNew = new Balance();
		Transaction transaction = new Transaction();
		 
		Double totalBalance=0.0 , initialBalance =0.0;
		Double amount = (double) balanceMapper.getTransactionAmt();
		
		transaction.setCustomerId(balanceMapper.getCustomerId());
		transaction.setTransactionAmt(balanceMapper.getTransactionAmt());
		transaction.setTransactionDt(String.valueOf(new Date(System.currentTimeMillis())));
		transaction.setTransactionId(generateTransactionId());
		transaction.setTransactionType(balanceMapper.getTransactionType());
//		System.out.println(previousBalance+"\n");
//		System.out.println("*** tr "+transaction+"\n");
//		
		String type = balanceMapper.getTransactionType();
		if(type.equalsIgnoreCase("deposit")) {
			//System.out.println(balanceMapper+"*******bal //////");
			if( previousBalance==null || previousBalance.isEmpty()){
			//	System.out.println(balanceMapper+"*******bal map");
			transaction.setBalance(balanceMapper.getTransactionAmt());
			balanceNew.setBalance(balanceMapper.getTransactionAmt());
				
			balanceNew.setCustomerId(balanceMapper.getCustomerId());
			balanceNew.setAccountNumber(balanceMapper.getAccountNumber());
			
			balanceRepository.save(balanceNew);
			transactionRepository.save(transaction);
			
			totalBalance =  amount;
			//return new ResponseEntity<>("Amount deposited successfully. Total balance is : "+amount,HttpStatus.OK);

			
				}
			else if(previousBalance != null || previousBalance.isPresent()) {
			//	System.out.println("\n"+previousBalance+"*******previousBalance");
			    balanceNew = 	balanceRepository.findById(balanceMapper.getCustomerId()).get();
				initialBalance = balanceNew.getBalance();
				totalBalance = initialBalance + amount;
				
				balanceNew.setBalance(totalBalance);
				transaction.setBalance(totalBalance);
				
				balanceRepository.save(balanceNew);
				transactionRepository.save(transaction);
			}
		}
		
		return totalBalance;
		//return new ResponseEntity<>("Amount deposited successfully. Total balance is : "+totalBalance,HttpStatus.OK);
	}

	public String generateTransactionId() {
      return UUID.randomUUID().toString();
  }

	public ResponseEntity<String> getBalanceWhenWithdraw(BalanceMapper balanceMapper) {
		Optional<Balance> previousBalance = balanceRepository.findById(balanceMapper.getCustomerId());
		//System.out.println(previousBalance);
		Balance balanceNew = new Balance();
		Transaction transaction = new Transaction();
		//ResponseEntity<String> response =null;
		 
		Double totalBalance=0.0 , initialBalance =0.0;
		Double amount = (double) balanceMapper.getTransactionAmt();
		
		
//		System.out.println(previousBalance+"\n");
//		System.out.println("*** tr "+transaction+"\n");
//		
		String type = balanceMapper.getTransactionType();
	//	if(type.equalsIgnoreCase("withdraw")) {
			//System.out.println(balanceMapper+"*******bal //////");
			if( previousBalance==null || previousBalance.isEmpty()){
				return new ResponseEntity<>("You have no amount deposited in your account... ",HttpStatus.NOT_FOUND);
			}
			
			else if(previousBalance != null || previousBalance.isPresent()) {
				
				 balanceNew = 	balanceRepository.findById(balanceMapper.getCustomerId()).get();
					initialBalance = balanceNew.getBalance();
					if(initialBalance > amount) {
					totalBalance = initialBalance - amount;
					
					transaction.setCustomerId(balanceMapper.getCustomerId());
					transaction.setTransactionAmt(balanceMapper.getTransactionAmt());
					transaction.setTransactionDt(String.valueOf(new Date(System.currentTimeMillis())));
					transaction.setTransactionId(generateTransactionId());
					transaction.setTransactionType(balanceMapper.getTransactionType());
					
					balanceNew.setBalance(totalBalance);
					transaction.setBalance(totalBalance);
					
					balanceRepository.save(balanceNew);
					transactionRepository.save(transaction);
					
					
					
					}
					else if(initialBalance < amount){
						return new ResponseEntity<>("you have less amount in your account : "+initialBalance+" can't process your withdraw request",HttpStatus.OK);
					}
					
					
			}
		//	}
		return new ResponseEntity<>(amount+"Amount withdraw successfully... ",HttpStatus.OK);
		
		
	}

	public List<Transaction> getTransactionbyUserId(int customerId) {
		
		 
		return transactionRepository.findByCustomerId(customerId);
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

//balance.setTransactionId(generateTransactionId());
//
//balance.setTransactionDt(new Date(System.currentTimeMillis()));
//
//if(balance.getTransactionType() == "deposit") {
//	BalanceRepository.
//}