package com.masai.services;

import java.util.List;
import java.util.Optional;

import com.masai.exception.TripBookingException;
import com.masai.model.Cab;
import com.masai.model.Driver;
import com.masai.model.TripBooking;
import com.masai.repository.TripBookingDao;

public class TripBookingServiceImp implements TripBookingService {
	
	TripBookingDao tripBookingDao;

	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) throws TripBookingException {
		
		if(tripBooking != null) {
			
			tripBookingDao.save(tripBooking);
			
			return tripBooking;

		}else {
			
			throw new TripBookingException("Please enter valid tripBooking details");
		}
		
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripBookingException {
		
		Optional<TripBooking> opt = tripBookingDao.findById(tripBooking.getTripBookingId());
		
		if(opt.isPresent()) {
			
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
			
			tripBookingDao.delete(opt.get());
			
			return opt.get();
		
		}else {
			throw new TripBookingException("Please enter valid tripBooking Id " + tripBookingId);
			
		}
		
	}

	@Override
	public List<TripBooking> viewAllTripsCustomer(Integer customerId) throws TripBookingException {
		
		List<TripBooking>listOfTripBookings = tripBookingDao.getAllTripBookingByTripId(customerId);
		
		if(!listOfTripBookings.isEmpty()) {
			
			return listOfTripBookings;
		
		}else {
			
		    throw new TripBookingException("There is no tripBooking to fetch with is customer id " + customerId);
		}
		
		
	}

	@Override
	public TripBooking calculateBill(Integer customerId) throws TripBookingException {
		
		List<TripBooking> listOfTripBookings = tripBookingDao.getAllTripBookingByTripId(customerId);
		
		if(!listOfTripBookings.isEmpty()) {
			
			TripBooking customerRecentTripBooking = listOfTripBookings.get(listOfTripBookings.size()-1);
			
			float distanceInKm = customerRecentTripBooking.getDistanceInKm();
			
			Driver driver = customerRecentTripBooking.getDriver();
			
			Cab cab = driver.getCab();
			
			float perKmRate = cab.getPerKmRate();
			
			float finalBill = distanceInKm * perKmRate;
			
			customerRecentTripBooking.setBill(finalBill);
			
			return customerRecentTripBooking;
			
		}else {
			throw new TripBookingException("Invalid customer id " + customerId);
		}
		
	}

	

}
