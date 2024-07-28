package com.microservices.spring.Microservices_bankApp_cardService.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.microservices.spring.Microservices_bankApp_cardService.Entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card , Integer>{

	boolean existsByCustomerId(int customerId);

	List<Card> findAllByCustomerId(int customerId);

	Card findByCardNumber(String cardNumber);

}
