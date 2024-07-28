package com.microservices.spring.Microservices_bankApp_registerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

//import com.microservices.spring.Microservices_bankApp_registerService.config.List;
import com.microservices.spring.Microservices_bankApp_registerService.entity.Customer;

//@Repository
public interface UserRegisterRepository extends JpaRepository<Customer , Integer>{

	List<Customer> findByEmail(String email);

}





