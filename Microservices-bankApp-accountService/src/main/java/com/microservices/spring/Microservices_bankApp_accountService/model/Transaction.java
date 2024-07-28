package com.microservices.spring.Microservices_bankApp_accountService.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class Transaction {

	
	private String transactionId;
	
	private int customerId;
	
	private String transactionType;
	
	private String transactionDt;
	
	private int transactionAmt;
	
	private double balance;
	
//	private String response;
	

	

	public Transaction() {
		super();
	}

	public Transaction(String transactionId, int customerId, String transactionType, String transactionDt,
			int transactionAmt, double balance) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.transactionType = transactionType;
		this.transactionDt = transactionDt;
		this.transactionAmt = transactionAmt;
		this.balance = balance;
		//this.response = response;
	}

	public String getTransactionDt() {
		return transactionDt;
	}

	public void setTransactionDt(String transactionDt) {
		this.transactionDt = transactionDt;
	}
//	public String getResponse() {
//		return response;
//	}
//
//	public void setResponse(String response) {
//		this.response = response;
//	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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

//	public Date getTransactionDt() {
//		return transactionDt;
//	}
//
//	public void setTransactionDt(Date transactionDt) {
//		this.transactionDt = transactionDt;
//	}

	public int getTransactionAmt() {
		return transactionAmt;
	}

	public void setTransactionAmt(int transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
