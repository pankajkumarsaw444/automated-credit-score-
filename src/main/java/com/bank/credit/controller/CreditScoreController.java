package com.bank.credit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.credit.service.CreditScoreService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/credit-score")
public class CreditScoreController {
	
	
	@Autowired
	private CreditScoreService creditScoreService;
	
	@GetMapping("/calculate")
	public int calculateScore(@RequestParam Double income) {
		return creditScoreService.calculateCreditScore(income);
    }

}
