package com.masai.services;

import com.masai.exception.CustomerException;
import com.masai.model.CustomerLogin;

public interface CustomerLoginService {
	
	public String Customerlogin(CustomerLogin al) throws CustomerException;
	
	public String Customerlogout(String key) throws CustomerException;
	
}
