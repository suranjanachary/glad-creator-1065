package com.masai.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.model.AdminLogin;
import com.masai.model.CurrentUserSession;
import com.masai.repository.AdminDao;
import com.masai.repository.AdminLoginDao;
import com.masai.repository.CurrentUserSessiondDao;

@Service
public class AdminLoginServiceimpl implements AdminLoginService{
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AdminLoginDao adminLoginDao;
	
	@Autowired
	private CurrentUserSessiondDao cusd;

	@Override
	public String Adminlogin(AdminLogin al) throws AdminException {
		
		Admin admin= adminDao.findById(al.getUserId()).orElseThrow(()->new AdminException("UseerId not find"));
		
		if(!admin.getUsername().equals(al.getAdminName())) {

			return "Please Enter correct username";
		}
		if(!admin.getPassword().equals(al.getPassword())) {

			return "Please Enter Correct Password";
		}
		
		
		Optional<CurrentUserSession> cu = cusd.findByuserId(al.getUserId());
		
		if(cu.isPresent()) {	
			return "User Alredy logged in";
		}
		
	 	RandomNumservice ran = new RandomNumservice();
			
	 	String uuid=ran.RandomNumber();
			
	 	CurrentUserSession cus= new CurrentUserSession();
	 	
		cus.setUserId(al.getUserId());
		cus.setLocalDateTime(LocalDateTime.now());
		cus.setUuid(uuid);
			
		adminLoginDao.save(al);
		
		CurrentUserSession cs=	cusd.save(cus);
		
		return cs.toString();
		
	}

	@Override
	public String Adminlogout(String key) throws AdminException {
		CurrentUserSession cus=	cusd.findByuuid(key).orElseThrow(()-> new AdminException("Enter correct Key"));

		adminLoginDao.deleteById(cus.getUserId());
		cusd.delete(cus);	
		return "Logout Successful";
	}

}
