package com.bank.credit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.credit.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByEmailId(String emailId);
	
	List<Customer> findByIncomeBetween(Double min, Double max);
}