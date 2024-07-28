package com.microservices.spring.Microservices_bankApp_balanceService.exception;

public class ResourceNotFoundException extends RuntimeException{

	private String message;

	public ResourceNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
}
