package com.masai.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.model.Customer;
import com.masai.model.Driver;
import com.masai.model.TripBooking;
import com.masai.repository.AdminDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.DriverDao;
import com.masai.repository.TripBookingDao;

@Service
public class AdminServiceImp implements AdminService {
	
	@Autowired
	public AdminDao admindao;
	
	@Autowired
	public TripBookingDao tripBookingDao;
	
	@Autowired
	public CustomerDao custDao;

	@Autowired
	public DriverDao drivDao;

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
	public List<TripBooking> getAllTrips() throws AdminException {
		
		List<TripBooking> c = tripBookingDao.findAll();
		
		if(c.size()==0) throw new AdminException("Trip List is empty");
			
	    return c;
	}

	@Override
	public List<TripBooking> getTripsDriverwise(Integer id) throws AdminException {
		
		
		Optional<Driver> d = drivDao.findById(id);
		
		if(d.get().getTripList().size()==0) throw new AdminException("Please enter valid driver id");
			
	    return d.get().getTripList();
			
		}
	

	@Override
	public List<TripBooking> getTripsCustomerWise(Integer customerId) throws AdminException {
		
Optional<Customer> c = custDao.findById(customerId);
		
		if(c.get().getTripList().size()==0) throw new AdminException("Please enter valid customer Id " + customerId);
			
	    return c.get().getTripList();
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
		
		List<TripBooking> listOfBookingBetweenDay = tripBookingDao.getAllTripBetweenDate(customerId,fromDate,toDate);
		
		if(!listOfBookingBetweenDay.isEmpty()) {
			
			return listOfBookingBetweenDay;
		}else {
			throw new AdminException("There is no data available between this dates");
		}
		
		
	}

}













