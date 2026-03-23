package com.bank.credit.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;

@CrossOrigin(origins = "*")
@RestController
public class ApiDocumentationController {
//
    @GetMapping("/api/docs")
    public Map<String, Object> getApiDocumentation() {
        Map<String, Object> response = new LinkedHashMap<>();
        
        response.put("application", "Automated Credit Score Analysis");
        response.put("version", "1.0");
        
        Map<String, Object> endpoints = new LinkedHashMap<>();

        Map<String, Object> creditScore = new LinkedHashMap<>();
        creditScore.put("method", "GET");
        creditScore.put("path", "/credit-score/calculate/{customerId}");
        creditScore.put("description", "Calculate credit score for a customer based on income");
        creditScore.put("params", "customerId (Long) - The customer ID");
        creditScore.put("returns", "Integer - Credit score value");
        creditScore.put("example", "GET http://localhost:8080/credit-score/calculate/1");
        endpoints.put("Calculate Credit Score", creditScore);
        
        Map<String, Object> getCustomers = new LinkedHashMap<>();
        getCustomers.put("method", "GET");
        getCustomers.put("path", "/api/customers");
        getCustomers.put("description", "Get all customers");
        getCustomers.put("returns", "List of Customer objects");
        getCustomers.put("example", "GET http://localhost:8080/api/customers");
        endpoints.put("Get All Customers", getCustomers);
        
        Map<String, Object> getCustomer = new LinkedHashMap<>();
        getCustomer.put("method", "GET");
        getCustomer.put("path", "/api/customers/{id}");
        getCustomer.put("description", "Get customer by ID");
        getCustomer.put("params", "id (Long) - The customer ID");
        getCustomer.put("returns", "Customer object");
        getCustomer.put("example", "GET http://localhost:8080/api/customers/1");
        endpoints.put("Get Customer by ID", getCustomer);
        
        Map<String, Object> createCustomer = new LinkedHashMap<>();
        createCustomer.put("method", "POST");
        createCustomer.put("path", "/api/customers");
        createCustomer.put("description", "Create a new customer");
        createCustomer.put("body", "Customer JSON object");
        createCustomer.put("returns", "Created Customer object");
        endpoints.put("Create Customer", createCustomer);
        
        Map<String, Object> updateCustomer = new LinkedHashMap<>();
        updateCustomer.put("method", "PUT");
        updateCustomer.put("path", "/api/customers/{id}");
        updateCustomer.put("description", "Update an existing customer");
        updateCustomer.put("params", "id (Long) - The customer ID");
        updateCustomer.put("body", "Customer JSON object");
        updateCustomer.put("returns", "Updated Customer object");
        endpoints.put("Update Customer", updateCustomer);
        
        Map<String, Object> deleteCustomer = new LinkedHashMap<>();
        deleteCustomer.put("method", "DELETE");
        deleteCustomer.put("path", "/api/customers/{id}");
        deleteCustomer.put("description", "Delete a customer");
        deleteCustomer.put("params", "id (Long) - The customer ID");
        deleteCustomer.put("returns", "Success message");
        endpoints.put("Delete Customer", deleteCustomer);
        
        response.put("endpoints", endpoints);
        return response;
    }
}

