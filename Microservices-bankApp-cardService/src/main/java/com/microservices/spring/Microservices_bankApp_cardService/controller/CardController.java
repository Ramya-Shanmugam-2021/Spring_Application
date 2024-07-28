package com.microservices.spring.Microservices_bankApp_cardService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.spring.Microservices_bankApp_cardService.Entity.Card;
import com.microservices.spring.Microservices_bankApp_cardService.exception.NoAmountInAccountException;
import com.microservices.spring.Microservices_bankApp_cardService.exception.ResourceNotFoundException;
import com.microservices.spring.Microservices_bankApp_cardService.service.CardService;

@RestController
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	private CardService cardService;

	@PostMapping("/createCard/{customerId}")
	public ResponseEntity<String> CreateCard(@PathVariable int customerId,@RequestBody Card card){
		try {
		Card newCard = cardService.CreateCard(customerId , card);	
		}
		catch(Exception ex) {
		      throw new RuntimeException("Error occurred in cardService", ex);
		}
		return new ResponseEntity<>("card created successfully...",HttpStatus.CREATED);
	}
	
	@GetMapping("/getCardDetails/{customerId}")
	public ResponseEntity<List<Card>> getCardDetails(@PathVariable int customerId){
		try {
			List<Card> card = cardService.getCardDetails(customerId);
			
		return ResponseEntity.ok(card);
		}
		catch(ResourceNotFoundException ex) {
			throw new ResourceNotFoundException(ex.getMessage());
		}
		catch(Exception ex) {
		      throw new RuntimeException("Error occurred in cardService", ex);
		}
	}
	
	@PutMapping("/amountUsed/{customerId}")
	public ResponseEntity<String> UpdateCardTransaction(@PathVariable int customerId,@RequestBody Card card){
		try {
		Card cardResult = cardService.UpdateCardTransaction(customerId , card);
		return new ResponseEntity<>("Transaction details updated successfully.!. "+cardResult.getAvailableAmount(),HttpStatus.OK);
		
		}
		catch(NoAmountInAccountException ex) {
			throw new NoAmountInAccountException(ex.getMessage());
		}
		catch(Exception ex) {
		      throw new RuntimeException("Error occurred while fetching the resource", ex);
		       
		}
	}
}
///