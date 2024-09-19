package com.ecommerce.EcomApp.controller;

import com.ecommerce.EcomApp.payload.OrderDTO;
import com.ecommerce.EcomApp.payload.OrderRequestDTO;
import com.ecommerce.EcomApp.service.OrderService;
import com.ecommerce.EcomApp.util.AuthUtil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

	 @Autowired
	    private OrderService orderService;

	    @Autowired
	    private AuthUtil authUtil;

	    @PostMapping("/order/users/payments/{paymentMethod}")
	    public ResponseEntity<OrderDTO> orderProducts(@PathVariable String paymentMethod, @RequestBody OrderRequestDTO orderRequestDTO) {
	        String emailId = authUtil.loggedInEmail();
	        OrderDTO order = orderService.placeOrder(
	                emailId,
	                orderRequestDTO.getAddressId(),
	                paymentMethod,
	                orderRequestDTO.getPgName(),
	                orderRequestDTO.getPgPaymentId(),
	                orderRequestDTO.getPgStatus(),
	                orderRequestDTO.getPgResponseMessage()
	        );
	        return new ResponseEntity<>(order, HttpStatus.CREATED);
	    }
}
