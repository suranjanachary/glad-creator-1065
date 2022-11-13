package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.TripBookingException;
import com.masai.model.Cab;
import com.masai.model.Customer;
import com.masai.model.Driver;
import com.masai.model.TripBooking;
import com.masai.repository.CustomerDao;
import com.masai.repository.DriverDao;
import com.masai.repository.TripBookingDao;

@Service
public class TripBookingServiceImp implements TripBookingService {
	
	@Autowired
	private TripBookingDao tripBookingDao;
	
	@Autowired
	private CustomerDao custDao;
	
	@Autowired
	private DriverDao driverDao;

	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking, Integer customerId) throws TripBookingException {
		
		Optional<Customer> c= custDao.findById(customerId);
		Customer c1= c.get();
		
		if(c1 == null) throw new TripBookingException("Please enter valid tripBooking details");
		
		List<Driver> dlist = driverDao.findAll();
		
		for(Driver d:dlist) {
			if(d.getTripList().size()==0) {
				tripBooking.setDriver(d);
				break;
			}
		}
		tripBooking.setCustomer(c1);
		tripBooking.setBill((float) (tripBooking.getDriver().getCab().getPerKmRate()) * (tripBooking.getDistanceInKm()));
		
		
			
			tripBookingDao.save(tripBooking);
			
			return tripBooking;
	
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripBookingException {
		
		Optional<TripBooking> opt = tripBookingDao.findById(tripBooking.getTripBookingId());
		
		
		if(opt.isPresent()) {
			
			
			 tripBooking.setCustomer(opt.get().getCustomer());
			 tripBooking.setDriver(opt.get().getDriver());
			 
			 
			
			TripBooking updatedTripBooking = tripBookingDao.save(tripBooking);
			
			return updatedTripBooking;
		
		}else {
			
			throw new TripBookingException("Please enter valid tripBooking details for update the tripBooking");
		}
		
	}

	@Override
	public TripBooking deleteTripBooking(Integer tripBookingId) throws TripBookingException {
		
		Optional<TripBooking> opt = tripBookingDao.findById(tripBookingId);
		
		if(opt.isPresent()) {
			
		List<TripBooking> triplist = opt.get().getDriver().getTripList();
			
		for(TripBooking tb:triplist) {	
			if(tb.getTripBookingId()==tripBookingId) {
				triplist.remove(tb);
			}
		}
		
		
		
		List<TripBooking> triplist2 = opt.get().getCustomer().getTripList();
		
		for(TripBooking tb2:triplist2) {	
			if(tb2.getTripBookingId()==tripBookingId) {
				triplist2.remove(tb2);
			}
		}
		
		
			tripBookingDao.delete(opt.get());
			
			return opt.get();
		
		}else {
			throw new TripBookingException("Please enter valid tripBooking Id " + tripBookingId);
			
		}
		
	}

	@Override
	public List<TripBooking> viewAllTripsCustomer(Integer customerId) throws TripBookingException {
		
		Optional<Customer>c = custDao.findById(customerId);
		
		
		if(c.get().getTripList().size()>0) {
			
			return c.get().getTripList();
		
		}else {
			
		    throw new TripBookingException("There is no tripBooking to fetch with is customer id " + customerId);
		}
		
		
	}

	@Override
	public TripBooking calculateBill(Integer customerId, Integer tripId ) throws TripBookingException {
		

		Optional<Customer> cu = custDao.findById(customerId);
		
		List<TripBooking> listtb = cu.get().getTripList();
		
		if(listtb.size()==0) {
			
			throw new TripBookingException("There is no tripBooking to fetch with is customer id " + customerId);
		}
		
		boolean flag= false;
		
		for(TripBooking tb3:listtb) {	
			if(tb3.getTripBookingId()==tripId) {
				flag=true;
				return tb3;
			}
		}
	
		if(flag==false) throw new TripBookingException( " Trip booking id is invalid " + tripId);
			
		return null;
			
		
		
	}

	

}
