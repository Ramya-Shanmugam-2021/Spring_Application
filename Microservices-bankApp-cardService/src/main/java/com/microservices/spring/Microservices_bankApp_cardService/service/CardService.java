package com.microservices.spring.Microservices_bankApp_cardService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservices.spring.Microservices_bankApp_cardService.Entity.Card;
import com.microservices.spring.Microservices_bankApp_cardService.Repository.CardRepository;
import com.microservices.spring.Microservices_bankApp_cardService.exception.NoAmountInAccountException;
import com.microservices.spring.Microservices_bankApp_cardService.exception.ResourceNotFoundException;

@Service
public class CardService {

	@Autowired
	private CardRepository cardRepository;
	
	public Card CreateCard(int customerId,Card card){
		ResponseEntity<String> response = null;
		//try {
		Card newCard = new Card();
		newCard.setAmountUsed(card.getAmountUsed());
		newCard.setAvailableAmount(card.getAvailableAmount());
		newCard.setCardNumber(card.getCardNumber());
		newCard.setCardType(card.getCardType());
		newCard.setCustomerId(card.getCustomerId());
		newCard.setTotalLimit(card.getTotalLimit());
		newCard.setCustomerId(customerId);
		
		cardRepository.save(newCard);
//		response = ResponseEntity
//				     .status(HttpStatus.CREATED)
//				     .body("User cards successfully created.,.");
			//}
//		catch(Exception ex) {
//			 response = ResponseEntity
//			            .status(HttpStatus.INTERNAL_SERVER_ERROR)
//			            .body("An exception occured due to " + ex.getMessage());

		
		return newCard;
		
	}

	public List<Card> getCardDetails(int customerId) {
		
		List<Card> cardData = new ArrayList<>();
		boolean exist = cardRepository.existsByCustomerId(customerId);
	
		if(exist) {
			cardData =  cardRepository.findAllByCustomerId(customerId);
			}
		else if(!exist) {
			throw new ResourceNotFoundException("card resource not available for you..");
		}
	return cardData;
	}

	public Card UpdateCardTransaction(int customerId, Card card) {
		Card newCard = cardRepository.findByCardNumber(card.getCardNumber());
		//ResponseEntity<String> response = null;
		double balanceAmount = newCard.getAvailableAmount();
		double initiallyUsedAmount = newCard.getAmountUsed();
		double AmountUsed = card.getAmountUsed();
		Card cardResult = null;
		//try {
			if(newCard !=null) {
				  if(balanceAmount > AmountUsed) {
			           balanceAmount = balanceAmount - AmountUsed;
			           AmountUsed = AmountUsed + initiallyUsedAmount;
			           newCard.setAmountUsed(AmountUsed);
			           newCard.setAvailableAmount(balanceAmount);
			           cardResult= cardRepository.save(newCard);
			       //response =ResponseEntity.status(HttpStatus.OK).body("Amount transfered..");
			
		          } 
				  else if(balanceAmount < AmountUsed) {
			           throw new NoAmountInAccountException("you have less amount in your card::"+balanceAmount);
		          }
		    }
			
			//}
//	catch(NoAmountInAccountException ex) {
//			throw new NoAmountInAccountException("you have less amount in your card :"+balanceAmount);
//		}
//		catch(Exception ex) {
//		      throw new RuntimeException("Error occurred while fetching the resource", ex);
//		       
//		}
		
		return cardResult ;
	}

	
}

//else if(newCard == null) {
//System.out.println("jjj");
////response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("You have no credit card available in this number");
//throw new ResourceNotFoundException("You have no credit card available in this number");
//}
