package com.masai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.model.TripBooking;
import com.masai.repository.AdminDao;

public class AdminServiceImp implements AdminService {
	
	@Autowired
	public AdminDao admindao;

	@Override
	public Admin insertAdmin(Admin admin) throws AdminException {
		
		return null;
	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {
		
		return null;
	}

	@Override
	public Admin deleteAdmin(Integer adminId) throws AdminException {
		
		return null;
	}

	@Override
	public List<TripBooking> getAllTrips(Integer customerId) throws AdminException {
		
		return null;
	}

	@Override
	public List<TripBooking> getTripsCabwise() {
		
		return null;
	}

}
