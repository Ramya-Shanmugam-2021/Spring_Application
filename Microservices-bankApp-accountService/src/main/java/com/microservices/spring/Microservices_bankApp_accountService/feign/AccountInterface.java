package com.microservices.spring.Microservices_bankApp_accountService.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservices.spring.Microservices_bankApp_accountService.model.AccountMapper;
import com.microservices.spring.Microservices_bankApp_accountService.model.Customer;
//import com.microservices.spring.Microservices_bankApp_balanceService.entity.Transaction;

//import com.microservices.spring.Microservices_bankApp_registerService.entity.Customer;

//, name="clientName"

@FeignClient(name="user-service",url="http://localhost:8081/bankApp" )
public interface AccountInterface {
	
	@GetMapping("/getUsers")
	public List<Customer> getAllUsers();
	
	@GetMapping("/getUser/{id}")
	public Customer getUserById(@PathVariable("id") int id);
			
	@PutMapping("/updateCustomer/{customerId}")
    public Customer updateCustomer(@PathVariable int customerId,@RequestBody Customer customer);
       
//	@DeleteMapping("/removeInfo/{customerId}")
//	public ResponseEntity<String> deleteInfoById(@PathVariable int customerId);

}


//@FeignClient("QUESTION-SERVICE-MICROSERVICE-EXAMPLE")
//public interface QuizInterface {
//
//	 @GetMapping("question/generate")
//	    public ResponseEntity<List<Integer>> getQuestionsForQuiz
//	            (@RequestParam String categoryName, @RequestParam Integer numQuestions );
//
//	    @PostMapping("question/getQuestions")
//	    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);
//
//	    @PostMapping("question/getScore")
//	    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
//
//}
