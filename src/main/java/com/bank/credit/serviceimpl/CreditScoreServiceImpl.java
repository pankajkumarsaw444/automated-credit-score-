package com.bank.credit.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.credit.entity.Customer;
import com.bank.credit.service.CreditScoreService;
import com.bank.credit.service.CustomerService;
import com.bank.credit.dto.CreditScoreResponse;

@Service
public class CreditScoreServiceImpl implements CreditScoreService {

    @Autowired
    private CustomerService customerService;

    @Override
    public int calculateCreditScore(Customer customer) {
        double income = customer.getIncome().doubleValue();
        if (income >= 500000) {
            return 800;
        } else if (income >= 300000) {
            return 700;
        } else {
            return 600;
        }
    }

    /**
     * Get credit score and rating for a customer by ID
     */
    @Override
    public CreditScoreResponse getCreditScore(Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }
        int score = calculateCreditScore(customer);
        String rating;
        if (score >= 750) {
            rating = "Excellent";
        } else if (score >= 650) {
            rating = "Good";
        } else {
            rating = "Poor";
        }
        return new CreditScoreResponse(customerId, score, rating);
    }
}
