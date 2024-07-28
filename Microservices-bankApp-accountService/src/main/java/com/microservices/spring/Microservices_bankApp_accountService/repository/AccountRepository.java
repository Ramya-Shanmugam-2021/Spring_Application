package com.microservices.spring.Microservices_bankApp_accountService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.microservices.spring.Microservices_bankApp_accountService.Entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

	Account findByCustomerId(int customerId);

}
