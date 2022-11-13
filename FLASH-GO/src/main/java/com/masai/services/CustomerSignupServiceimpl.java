package com.masai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.repository.CurrentUserSessiondDao;
import com.masai.repository.CustomerDao;

@Service
public class CustomerSignupServiceimpl implements CustomerSignupService{

	
	@Autowired
	private CustomerDao adao;
	
	@Autowired
	private CurrentUserSessiondDao cusd;
	
	@Override
	public Customer SignupCustomer(Customer customer) {
		
		Customer Customer1=adao.save(customer);
		return Customer1;
	}

	@Override
	public Customer UpdateCustomer(Customer customer, String key) throws CustomerException {
		CurrentUserSession cu=	cusd.findByuuid(key).orElseThrow(()-> new CustomerException("User Not Logged in"));
		
		if(customer.getCustomerId()==cu.getUserId()) {
			return adao.save(customer);
		}
		else
			throw new CustomerException("Please Enter a correct Customer id");
		
		}
	}
