package com.microservices.spring.Microservices_bankApp_accountService.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.spring.Microservices_bankApp_accountService.model.Transaction;

//import com.microservices.spring.Microservices_bankApp_balanceService.entity.Transaction;

//@FeignClient(name="BalanceTrancaction-service",url="http://localhost:8082/bankApp" )
@FeignClient(value = "MICROSERVICES-BANKAPP-BALANCESERVICE")
public interface BalanceTrancactionInterface {

	@GetMapping("/balance/getTransactionInfo/{customerId}")
	public List<Transaction> getTransactionbyUserId(@PathVariable int customerId);
}
