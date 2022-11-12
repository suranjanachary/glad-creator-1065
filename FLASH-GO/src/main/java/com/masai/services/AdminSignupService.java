package com.masai.services;

import com.masai.exception.AdminException;
import com.masai.model.Admin;

public interface AdminSignupService {
	
	public Admin signupAdmin(Admin admin);
	
	public Admin updateAdmin(Admin admin,String key) throws AdminException;
	
}