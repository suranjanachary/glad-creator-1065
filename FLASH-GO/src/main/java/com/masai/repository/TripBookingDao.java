package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.TripBooking;

public interface TripBookingDao extends JpaRepository<TripBooking, Integer>{
	

}
