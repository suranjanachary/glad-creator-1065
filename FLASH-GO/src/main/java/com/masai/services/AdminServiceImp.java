package com.masai.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.model.TripBooking;
import com.masai.repository.AdminDao;
import com.masai.repository.TripBookingDao;

@Service
public class AdminServiceImp implements AdminService {
	
	@Autowired
	public AdminDao admindao;
	
	@Autowired
	public TripBookingDao tripBookingDao;

	@Override
	public Admin insertAdmin(Admin admin) throws AdminException {
		
		if(admin != null) {
			Admin savedAdmin = admindao.save(admin);
			return savedAdmin;
			
		}else {
			throw new AdminException("Please enter valid admin details");
			
		}
		
	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {
		
		Optional<Admin> opt = admindao.findById(admin.getAdminId());
		
		if(opt.isPresent()) {
			
			Admin updatedAdminDetails = admindao.save(admin);
			
			return updatedAdminDetails;
		}else {
			
			throw new AdminException("Invalid Admin details");
		}
		
	}

	@Override
	public Admin deleteAdmin(Integer adminId) throws AdminException {
		
		Optional<Admin> opt = admindao.findById(adminId);
		
		if(opt.isPresent()) {
			
			admindao.delete(opt.get());
			
			return opt.get();
		}else {
			
			throw new AdminException("Please enter valid adminId");
		}
		
	}

	@Override
	public List<TripBooking> getAllTrips(Integer customerId) throws AdminException {
		
		List<TripBooking> listOfBooking = tripBookingDao.getAllTripBookingByTripId(customerId);
		
		if(!listOfBooking.isEmpty()) {
			return listOfBooking;
		}else {
			throw new AdminException("Please enter valid customer Id " + customerId);
		}
		
	}

	@Override
	public List<TripBooking> getTripsCabwise() throws AdminException {
		
		List<TripBooking> listOfBooking = tripBookingDao.getAllTrips();
		
		if(!listOfBooking.isEmpty()) {
			return listOfBooking;
		}else {
			throw new AdminException("There is not data to show");
		}
	}

	@Override
	public List<TripBooking> getTripsCustomerWise() throws AdminException {
		
		List<TripBooking> listOfBooking = tripBookingDao.getAllTrips();
		
		if(!listOfBooking.isEmpty()) {
			return listOfBooking;
			
		}else {
			throw new AdminException("There is not data to show");
			
		}
	}

	@Override
	public List<TripBooking> getTripsDateWise() throws AdminException {
		
		List<TripBooking> listOfBooking = tripBookingDao.getAllTrips();
		
		if(!listOfBooking.isEmpty()) {
			return listOfBooking;
		}else {
			throw new AdminException("There is not data to show");
		}
	}

	@Override
	public List<TripBooking> getAllTripsForDays(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate)
			throws AdminException {
		
		List<TripBooking> listOfBookingBetweenDay = tripBookingDao.getAllTripBookingByDayWise(customerId,fromDate,toDate);
		
		if(!listOfBookingBetweenDay.isEmpty()) {
			
			return listOfBookingBetweenDay;
		}else {
			throw new AdminException("There is no data available between this dates");
		}
		
		
	}

}













