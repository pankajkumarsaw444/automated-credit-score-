package com.bank.credit.service;

import java.util.List;
import com.bank.credit.entity.Customer;

public interface CustomerService {

    // CREATE
    Customer createCustomer(Customer customer);

    // READ BY ID
    Customer getCustomerById(Long id);

    // READ ALL
    List<Customer> getAllCustomers();

    // UPDATE
    Customer updateCustomer(Long id, Customer customer);

    // DELETE
    void deleteCustomer(Long id);
    
    // In CustomerService.java
    Customer getCustomerByEmailId(String emailId);
}
