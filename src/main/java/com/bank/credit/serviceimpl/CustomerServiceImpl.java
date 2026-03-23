
package com.bank.credit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.credit.entity.Customer;
import com.bank.credit.repository.CustomerRepository;
import com.bank.credit.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // CREATE
    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // READ BY ID
    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    // READ ALL
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // UPDATE
    @Override
    public Customer updateCustomer(Long id, Customer customer) {

        Customer existingCustomer = getCustomerById(id);

        existingCustomer.setIncome(customer.getIncome());
        existingCustomer.setEmailId(customer.getEmailId());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());

        // PAN & Name update nahi hota (banking rule)

        return customerRepository.save(existingCustomer);
    }

    // DELETE
    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    
    @Override
    public Customer getCustomerByEmailId(String emailId) {
        return customerRepository.findByEmailId(emailId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
    
    @Override
    public List<Customer> getCustomersByIncomeRange(Double min, Double max) {
        return customerRepository.findByIncomeBetween(min, max);
    }
}
