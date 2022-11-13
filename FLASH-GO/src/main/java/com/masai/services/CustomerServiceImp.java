package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repository.CustomerDao;
@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer insertCustomer(Customer customer) throws CustomerException {
		
		Customer customer2 = customerDao.save(customer);
		
		return customer2;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		
		Optional<Customer> optional = customerDao.findById(customer.getCustomerId());
		
		if(optional.isPresent()) {
			
			customer.setTripList(optional.get().getTripList());
			
			Customer updatedCustomer = customerDao.save(customer);
			
			return updatedCustomer;
		
		}else {
			throw new CustomerException("Customer details not present to updated the customer");
		}
		
	}

	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerException {
		
		Optional<Customer> optional = customerDao.findById(customerId);
		
		if(optional.isPresent()) {
			
			customerDao.delete(optional.get());
			
			return optional.get();
			
		}else {
			throw new CustomerException("Customer not found with this customer id" + customerId);
		}
		
	}

	@Override
	public List<Customer> viewCustomer() throws CustomerException {
		
		List<Customer> listOfCustomer = customerDao.getAllCustomers();
	
		if(!listOfCustomer.isEmpty()) {
			
			return listOfCustomer;
	
		}else {
			throw new CustomerException("No customer found");
		}
		
	}

	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerException {
		
		Optional<Customer> optional = customerDao.findById(customerId);
		
		if(optional.isPresent()) {
			
			return optional.get();
			
		}else {
			throw new CustomerException("Customer not found with this customer id " + customerId);
		}
		
	}

	//login part
	
	@Override
	public Customer validateCustomer(String username, String password) throws CustomerException {
		
		
		
		return null;
	}

}























