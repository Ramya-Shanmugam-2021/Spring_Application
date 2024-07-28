package com.microservices.spring.Microservices_bankApp_cardService.exception;


public class NoAmountInAccountException extends RuntimeException {

	private String message;
	
	public NoAmountInAccountException(String message){
		super(message);
		this.message = message;
	}
	
//private double message;
//	
//	public NoAmountInAccountException(double message){
//		super(message);
//		this.message = message;
//	}
}
