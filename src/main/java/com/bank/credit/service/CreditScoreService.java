package com.bank.credit.service;


import com.bank.credit.entity.Customer;
import com.bank.credit.dto.CreditScoreResponse;

public interface CreditScoreService {
    int calculateCreditScore(Customer customer);

    /**
     * Get credit score and rating for a customer by ID
     * @param customerId the customer ID
     * @return CreditScoreResponse DTO
     */
    CreditScoreResponse getCreditScore(Long customerId);
}

// Score logic