package com.masai.services;

import com.masai.exception.AdminException;
import com.masai.model.AdminLogin;

public interface AdminLoginService {
	
	public String Adminlogin(AdminLogin al) throws AdminException;
	
	public String Adminlogout(String key) throws AdminException;
	
}
