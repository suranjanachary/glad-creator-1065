package com.masai.services;

import java.time.LocalDateTime;
import java.util.List;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.model.TripBooking;

public interface AdminService {
	
	public Admin insertAdmin(Admin admin) throws AdminException;
	
	public Admin updateAdmin(Admin admin) throws AdminException;
	
	public Admin deleteAdmin(Integer adminId) throws AdminException;
	
	public List<TripBooking> getAllTrips() throws AdminException;

	public List<TripBooking> getTripsDriverwise(Integer id) throws AdminException;
	
	public List<TripBooking> getTripsCustomerWise(Integer customerId) throws AdminException;
	
	public List<TripBooking> getTripsDateWise() throws AdminException;
	
	public List<TripBooking> getAllTripsForDays(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate)throws AdminException;
}















