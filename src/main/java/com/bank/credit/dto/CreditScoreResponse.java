package com.bank.credit.dto;

public class CreditScoreResponse {
    private Long customerId;
    private int creditScore;
    private String rating;

    public CreditScoreResponse() {}

    public CreditScoreResponse(Long customerId, int creditScore, String rating) {
        this.customerId = customerId;
        this.creditScore = creditScore;
        this.rating = rating;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "CreditScoreResponse{" +
                "customerId=" + customerId +
                ", creditScore=" + creditScore +
                ", rating='" + rating + '\'' +
                '}';
    }
}
