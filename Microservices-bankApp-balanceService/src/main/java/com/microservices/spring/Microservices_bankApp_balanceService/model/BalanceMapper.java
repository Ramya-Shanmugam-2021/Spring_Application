package com.microservices.spring.Microservices_bankApp_balanceService.model;

import java.sql.Date;

import jakarta.persistence.Id;

public class BalanceMapper {

	private long accountNumber;
	//private double balance;
	private int customerId;
	
	//private String transactionId;
	private String transactionType;
	
	//private Date transactionDt;
	
	private int transactionAmt;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getTransactionAmt() {
		return transactionAmt;
	}

	public void setTransactionAmt(int transactionAmt) {
		this.transactionAmt = transactionAmt;
	}
	
	
}
