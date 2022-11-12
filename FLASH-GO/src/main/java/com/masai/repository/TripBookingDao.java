package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.TripBooking;

public interface TripBookingDao extends JpaRepository<TripBooking, Integer>{
	
	
	@Query("from TripBooking t where t.tripBookingId = ?1")
	public List<TripBooking> getAllTripBookingByTripId(Integer customerId);

}
