package com.microservices.spring.Microservices_bankApp_accountService.model;

import jakarta.persistence.Id;

public class AccountMapper {
	
    private int customerId;
    private long accountNumber;
	private String accountType;
	
	private String branchAddress;
	private String name;
	private String email;
	private String mobileNumber;
	private String address;
	private String bankName;
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
//	private Customer customer;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
	
//	private String name;
//	private String email;
//	private String role;
//	
	
	

	//private String createDt;

//	public AccountMapper(int customerId, String name, String email, String role, long accountNumber, String accountType,
//			String branchAddress, String createDt) {
//		super();
//		this.customerId = customerId;
//		this.name = name;
//		this.email = email;
//		this.role = role;
//		this.accountNumber = accountNumber;
//		this.accountType = accountType;
//		this.branchAddress = branchAddress;
//		this.createDt = createDt;
//	}

//	public int getCustomerId() {
//		return customerId;
//	}
//
//	public void setCustomerId(int customerId) {
//		this.customerId = customerId;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//
//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}

//	public long getAccountNumber() {
//		return accountNumber;
//	}
//
//	public void setAccountNumber(long accountNumber) {
//		this.accountNumber = accountNumber;
//	}
//
//	public String getAccountType() {
//		return accountType;
//	}
//
//	public void setAccountType(String accountType) {
//		this.accountType = accountType;
//	}
//
//	public String getBranchAddress() {
//		return branchAddress;
//	}
//
//	public void setBranchAddress(String branchAddress) {
//		this.branchAddress = branchAddress;
//	}
//
//	public String getCreateDt() {
//		return createDt;
//	}
//
//	public void setCreateDt(String createDt) {
//		this.createDt = createDt;
//	}
//	
	
}
