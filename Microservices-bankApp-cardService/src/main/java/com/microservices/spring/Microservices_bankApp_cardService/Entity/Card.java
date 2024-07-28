package com.microservices.spring.Microservices_bankApp_cardService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cardId;
	
	private double amountUsed;
	private double availableAmount;
	
	private String cardNumber;
	private String cardType;
	
	private int customerId;
	
	private double totalLimit;

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public double getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(double availableAmount) {
		this.availableAmount = availableAmount;
	}

	

	public double getAmountUsed() {
		return amountUsed;
	}

	public void setAmountUsed(double amountUsed) {
		this.amountUsed = amountUsed;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getTotalLimit() {
		return totalLimit;
	}

	public void setTotalLimit(double totalLimit) {
		this.totalLimit = totalLimit;
	}
	
	
}
