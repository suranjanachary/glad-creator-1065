package com.masai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.model.CurrentUserSession;
import com.masai.repository.AdminDao;
import com.masai.repository.CurrentUserSessiondDao;

@Service
public class AdminSignupServiceImpl implements AdminSignupService{

	@Autowired
	private AdminDao adao;
	
	@Autowired
	private CurrentUserSessiondDao cusd;
	
	
	@Override
	public Admin signupAdmin(Admin admin) {
		
		Admin admin1 = adao.save(admin);
		
		return admin1;
	}

	@Override
	public Admin updateAdmin(Admin admin, String key) throws AdminException {
		
		CurrentUserSession cu=	cusd.findByuuid(key).orElseThrow(()-> new AdminException("User Not Logged in"));
		
		return adao.save(admin);
	}

}
