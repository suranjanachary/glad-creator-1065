package com.masai.services;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;

public interface CustomerSignupService {
	
	public Customer SignupCustomer(Customer customer);
	 
	public Customer UpdateCustomer(Customer customer,String key) throws CustomerException;
	
}
