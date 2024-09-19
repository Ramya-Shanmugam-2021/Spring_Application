package com.ecommerce.EcomApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.EcomApp.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
