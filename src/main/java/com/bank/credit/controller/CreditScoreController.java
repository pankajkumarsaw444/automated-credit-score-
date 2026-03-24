package com.bank.credit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.credit.entity.Customer;
import com.bank.credit.service.CreditScoreService;
import com.bank.credit.service.CustomerService;
import com.bank.credit.dto.CreditScoreResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/credit-score")
public class CreditScoreController {
	
	@Autowired
	private CreditScoreService creditScoreService;
	
	@Autowired
	private CustomerService customerService;
	
	// Old endpoint for backward compatibility
	@GetMapping("/calculate/{customerId}")
	public int calculateScore(@PathVariable Long customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		if (customer == null) {
			throw new RuntimeException("Customer not found");
		}
		return creditScoreService.calculateCreditScore(customer);
	}

	// New endpoint: returns CreditScoreResponse DTO
	@GetMapping("/{customerId}")
	public CreditScoreResponse getCreditScore(@PathVariable Long customerId) {
		return creditScoreService.getCreditScore(customerId);
	}

}
