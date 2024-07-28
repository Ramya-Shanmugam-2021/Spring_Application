package com.microservices.spring.Microservices_bankApp_cardService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CardExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex){
		//System.out.println(" 333 ");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	//	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("resource none");
	}
	@ExceptionHandler(NoAmountInAccountException.class)
	public ResponseEntity<Object> handleNoAmountException(NoAmountInAccountException ex){
		//System.out.println(" 333 ");
		return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(ex.getMessage());
	//	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("resource none");
	}
	
//	@ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
//		System.out.println(" 666 ");
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
    	//System.out.println(" 444 ");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
    
    
}
