package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

	
	@Query("from Customer")
	public List<Customer> getAllCustomers();
}
