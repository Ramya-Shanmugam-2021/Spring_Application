package com.microservices.spring.Microservices_bankApp_balanceService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.spring.Microservices_bankApp_balanceService.entity.Balance;

@Repository
public interface BalanceRepository extends JpaRepository<Balance,Integer>{

}
