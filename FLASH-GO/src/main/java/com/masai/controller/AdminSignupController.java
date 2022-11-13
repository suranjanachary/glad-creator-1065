package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.services.AdminSignupService;

public class AdminSignupController {
	
	@Autowired
	private AdminSignupService as;
	
	@PostMapping("/admin/signup")
	public ResponseEntity<Admin> CreateAdmin(@RequestBody Admin admin) {
		Admin admin1 = as.signupAdmin(admin);
		
		return new ResponseEntity<Admin>(admin1,HttpStatus.OK);
		
	}
	
	@PutMapping("/admin/update")
	public Admin UpdateAdmin(@RequestBody Admin admin,@RequestParam String key) throws AdminException {
		
		return as.updateAdmin(admin, key);
	}
	
}
