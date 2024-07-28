package com.microservices.spring.Microservices_bankApp_registerService.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservices.spring.Microservices_bankApp_registerService.entity.Customer;
import com.microservices.spring.Microservices_bankApp_registerService.exception.ResourceNotFoundException;
import com.microservices.spring.Microservices_bankApp_registerService.repository.UserRegisterRepository;

@Service
public class UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRegisterRepository userRegisterRepository;
	
//	 private static final Logger logger = LoggerFactory.getLogger(ResourceService.class);
	
//	 public ResponseEntity<String> addQuestion(Customer customer) {
//	        questionDao.save(question);
//	        return new ResponseEntity<>("success",HttpStatus.CREATED);
//	    }
	
	public ResponseEntity<String> saveUser(Customer customer){
		Customer savedCustomer = null;
		ResponseEntity response = null;
		try {
			String hashPwd = passwordEncoder.encode(customer.getPassword());
			customer.setPassword(hashPwd);
			customer.setRole("user");
			
			savedCustomer = userRegisterRepository.save(customer);
	         
	        if (savedCustomer.getId() > 0) {
	            response = ResponseEntity
	                    .status(HttpStatus.CREATED)
	                    .body("Given user details are successfully registered");
	        }
	    } catch (Exception ex) {
	        response = ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("An exception occured due to " + ex.getMessage());
	    }
	    return response;
		}

	public Customer getUserDetailsAfterLogin(Authentication authentication) {
		System.out.println("  11 ");
//		List<Customer> customers = userRegisterRepository.findByEmail(authentication.getName());
//		System.out.println(" 22 ");
//		if (customers.size() > 0) {
//			System.out.println(" 33 ");
//            return customers.get(0);
//        } else {
//        	System.out.println(" 44 4");
//            return null;
//        }
		return null;
	}
	
	//////////********************
	public List<Customer> getUserData() {
		System.out.println("bh000 "+userRegisterRepository.findAll());
		
		return userRegisterRepository.findAll();
	}

	public Customer getUserById(int id) {
		System.out.println(userRegisterRepository.findById(id).get());
		System.out.println("from get user url");
		 return userRegisterRepository.findById(id).get();
		 
	}

	public Customer updateCustomer(int customerId, Customer customer) {
	Customer savedCustomer =	userRegisterRepository.findById(customerId).get();
	savedCustomer.setMobileNumber(customer.getMobileNumber());
	savedCustomer.setAddress(customer.getAddress());
	
		return userRegisterRepository.save(savedCustomer);
	}

	

	    public void deleteInfoById(int customerId) {
	    	System.out.println(" ********* ");
	        if (!userRegisterRepository.existsById(customerId)) {
	        	System.out.println(" 333 ");
	           // logger.error("Resource with id {} not found", id);
	            throw new ResourceNotFoundException("Resource with id " + customerId + " not found");
	        }
	        try {
	        	System.out.println(" 888 ");
	        	userRegisterRepository.deleteById(customerId);
	        	System.out.println(" 999 ");
	        } catch (Exception ex) {
	        	System.out.println(" 777 ");
	          //  logger.error("Error occurred while deleting resource with id {}: {}", id, ex.getMessage());
	            throw new RuntimeException("Error occurred while deleting the resource");
	        }
	    }
	/*public ResponseEntity<String> deleteInfoById(int customerId) {
		ResponseEntity<String> response = null;
		try {
		if(userRegisterRepository.existsById(customerId)) {
			 userRegisterRepository.deleteById(customerId);
			System.out.println("i am hereeeee");
			
		}
		}catch(Exception ex) {
			
		}
		return response;
	}
	 public void deleteResource(Long id) {
	        if (!resourceRepository.existsById(id)) {
	            throw new ResourceNotFoundException("Resource with id " + id + " not found");
	        }
	        try {
	            resourceRepository.deleteById(id);
	        } catch (Exception ex) {
	            throw new RuntimeException("Error occurred while deleting the resource");
	        }
	    } */
//	public boolean deleteInfoById(int customerId) {
//		//Customer savedCustomer =	userRegisterRepository.findById(customerId).get();
//		 if (userRegisterRepository.existsById(customerId)) {
//			 userRegisterRepository.deleteById(customerId);
//	            return true;
//	        }
//		 
//		 return false;
////		ResponseEntity response = null;
////		try {
////		if((userRegisterRepository.findById(customerId).get()) != null) {
////			userRegisterRepository.deleteById(customerId);
////			 response = ResponseEntity
////                    .status(HttpStatus.CREATED)
////                    .body(" user details are successfully deleted");
////			 //return response;
////		}
////		else if((userRegisterRepository.findById(customerId).get()) == null) {
////			System.out.println("/*******"+userRegisterRepository.findById(customerId).get()+"/***");
////			response = ResponseEntity
////					.status(HttpStatus.NO_CONTENT)
////                    .body("Given user account is not present ****/*  ");
////		}
////		}
////		catch(Exception ex) {
////			System.out.println("/*******hello .. "+"/***");
////			
////			response = ResponseEntity
////                    .status(HttpStatus.NOT_FOUND)
////                    .body("Given user account is not present .../.  "+ex.getMessage());
////			 //return response;
////		}
////		 
////		return response;
//	}

		
		

}
//