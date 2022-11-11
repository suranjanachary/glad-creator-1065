package com.masai.services;

import java.util.List;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.model.TripBooking;

public interface AdminService {
	
	public Admin insertAdmin(Admin admin) throws AdminException;
	
	public Admin updateAdmin(Admin admin) throws AdminException;
	
	public Admin deleteAdmin(Integer adminId) throws AdminException;
	
	public List<TripBooking> getAllTrips(Integer customerId) throws AdminException;

	public List<TripBooking> getTripsCabwise();
}
