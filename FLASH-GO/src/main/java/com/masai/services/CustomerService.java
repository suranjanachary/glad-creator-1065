package com.masai.services;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;

public interface CustomerService {
	
	public Customer insertCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer) throws CustomerException;
	
	public Customer deleteCustomer(Integer customerId) throws CustomerException;
	
	public List<Customer> viewCustomer() throws CustomerException;
	
	public Customer viewCustomer(Integer customerId) throws CustomerException;
	
	public Customer validateCustomer(String username, String password) throws CustomerException;
    

}
