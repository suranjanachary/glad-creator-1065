package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.CustomerLogin;
import com.masai.services.CustomerLoginService;

@RestController
public class CustomerLoginController {
	
	@Autowired
	private CustomerLoginService userLoginservice;
	
	@PostMapping("/user/login")
	public String userLoginHandler(@RequestBody CustomerLogin al) throws CustomerException {
		return userLoginservice.Customerlogin(al);
		 
	}
	
	@DeleteMapping("/user/logout")
	public String userLogoutHandler(@RequestParam String key )throws  CustomerException {
	return userLoginservice.Customerlogout(key);
		
	}
}
