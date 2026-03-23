package com.bank.credit.service;

import com.bank.credit.entity.Customer;

public interface CreditScoreService {
    int calculateCreditScore(Customer customer);
}

// Score logic