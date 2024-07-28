package com.microservices.spring.Microservices_bankApp_cardService.exception;

import org.springframework.stereotype.Component;

//@Component
public class ResourceNotFoundException extends RuntimeException{
	
	private String message;
	
	    public ResourceNotFoundException(String message) {
	    	super(message);
	    	this.message=message;
	    	 
	    }
	

}
