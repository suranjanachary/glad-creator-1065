package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.services.CustomerService;

@RestController
public class CustomerController { 

@Autowired
private CustomerService cusService;
	
	@PostMapping("/regcustomer")
	public ResponseEntity<Customer> regCustomerHandler (@Valid @RequestBody Customer cust) throws CustomerException{
		Customer customer= cusService.insertCustomer(cust);
		 return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}
	
	@PutMapping("/updatecustomer")
	public ResponseEntity<Customer> updateCustomerHandler(@Valid @RequestBody Customer c1) throws CustomerException{
		Customer updatecust = cusService.updateCustomer(c1);
		
		return new ResponseEntity <Customer>(updatecust,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecustomer/{id}")
	public ResponseEntity<Customer> deleteCustomerByIdHandler( @PathVariable Integer id) throws CustomerException{
		Customer deletecust = cusService.deleteCustomer(id);
		
		return new ResponseEntity <Customer>(deletecust,HttpStatus.OK);
	}
	
	@GetMapping("/viewallcustomers")
	public ResponseEntity<List<Customer>> getAllCustomerHandler() throws CustomerException{
		List<Customer> employees = cusService.viewCustomer();
		
		return new ResponseEntity<List<Customer>>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/getcustomerbyid/{id}")
	public ResponseEntity<Customer> getEmployeeByAddAndNameHandler(@PathVariable Integer id) throws CustomerException{
		Customer customerdata = cusService.viewCustomer(id);
		
	   return new ResponseEntity<Customer>(customerdata,HttpStatus.OK);
	}
	
	
	
	
	
	
}
