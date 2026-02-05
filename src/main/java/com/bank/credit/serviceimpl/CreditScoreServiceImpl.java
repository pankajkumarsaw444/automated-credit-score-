package com.bank.credit.serviceimpl;

import org.springframework.stereotype.Service;
import com.bank.credit.service.CreditScoreService;

@Service
public class CreditScoreServiceImpl implements CreditScoreService {

    @Override
    public int calculateCreditScore(Double income) {

        if (income >= 500000) {
            return 800;
        } else if (income >= 300000) {
            return 700;
        } else {
            return 600;
        }
    }
}

