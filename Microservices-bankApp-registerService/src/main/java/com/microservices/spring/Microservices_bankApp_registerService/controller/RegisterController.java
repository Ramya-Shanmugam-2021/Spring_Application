package com.microservices.spring.Microservices_bankApp_registerService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.microservices.spring.Microservices_bankApp_registerService.entity.Customer;
import com.microservices.spring.Microservices_bankApp_registerService.exception.ResourceNotFoundException;
import com.microservices.spring.Microservices_bankApp_registerService.repository.UserRegisterRepository;
import com.microservices.spring.Microservices_bankApp_registerService.service.UserService;

@RestController
@RequestMapping("/bankApp")
public class RegisterController {
	
	@Autowired
	private UserRegisterRepository userRegisterRepository;
	
	@Autowired
	private UserService userService;
	
		
	@PostMapping("/userRegistration")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer){
			
			return userService.saveUser(customer);
		
		}
//	
	
//	 @RequestMapping("/userLogin")
//	    public Customer getUserDetailsAfterLogin(Authentication authentication) {
//		System.out.println("hi");
//		// return  userService.getUserDetailsAfterLogin(authentication);
//		List<Customer> customers = userRegisterRepository.findByEmail(authentication.getName());
//        if (customers.size() > 0) {
//            return customers.get(0);
//        } else {
//            return null;
//        }  
//
//	    }
	 
	@GetMapping("/getUsers")
	public List<Customer> getAllUsers(){
		return userService.getUserData();
	}
	
	@GetMapping("/getUser/{id}")
	public Customer getUserById(@PathVariable int id){
		return userService.getUserById(id);
	}
	
	//testing url
	@GetMapping("/getAccount")
	public String getAccountDetails() {
		return "Hi I am working ";
	}
	
	@PutMapping("/updateCustomer/{customerId}")
    public Customer updateCustomer(@PathVariable int customerId,@RequestBody Customer customer) {
        return userService.updateCustomer(customerId,customer);
		
	}
	
	@DeleteMapping("/removeInfo/{customerId}")
	public ResponseEntity<Void> deleteInfoById(@PathVariable int customerId){
		System.out.println(" /////''']]]]]] ");
		try {
			System.out.println(" /////''';[kjhgghh ");
			userService.deleteInfoById(customerId);
			System.out.println(" 111 ");
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException ex) {
        	System.out.println(" 2222 ");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        } catch (Exception ex) {
        	System.out.println(" 5555 ");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while deleting the resource", ex);
        }
	}
	  
}
//	@DeleteMapping("/removeInfo/{customerId}")
//	public ResponseEntity<String> deleteInfoById(@PathVariable int customerId) {
//		ResponseEntity<String> response= null;
//		boolean isRemoved =  userService.deleteInfoById(customerId);
//		if(!isRemoved) {
//			return response = ResponseEntity
//					.status(HttpStatus.NOT_FOUND)
//                  .body("Given user account is not present ****/*  ");
//		}
//		else {
//		response = ResponseEntity
//              .status(HttpStatus.NO_CONTENT)
//              .body("Given user account is not present .../.  ");
//		}
//		return response;
//	}
//	}

//@Autowired
//private CustomerRepository customerRepository;
//
//@Autowired
//private PasswordEncoder passwordEncoder;
//
//@PostMapping("/register")
//public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
//    Customer savedCustomer = null;
//    ResponseEntity response = null;
//    try {
//        String hashPwd = passwordEncoder.encode(customer.getPwd());
//        customer.setPwd(hashPwd);
//        savedCustomer = customerRepository.save(customer);
//        if (savedCustomer.getId() > 0) {
//            response = ResponseEntity
//                    .status(HttpStatus.CREATED)
//                    .body("Given user details are successfully registered");
//        }
//    } catch (Exception ex) {
//        response = ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body("An exception occured due to " + ex.getMessage());
//    }
//    return response;
//}
