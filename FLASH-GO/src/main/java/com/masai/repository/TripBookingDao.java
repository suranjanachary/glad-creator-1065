package com.masai.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.TripBooking;

@Repository
public interface TripBookingDao extends JpaRepository<TripBooking, Integer>{
	
	
	@Query("from TripBooking t where t.tripBookingId = ?1")
	public List<TripBooking> getAllTripBookingByTripId(Integer customerId);
	
	@Query("from TripBooking")
	public List<TripBooking> getAllTrips();
	
	
//	@Query(value = "from EntityClassTable t where yourDate BETWEEN :startDate AND :endDate")
	
	
	@Query("select t from TripBooking t where t.fromDateTime=?2 and t.toDateTime=?3 and t.customer = (select c from Customer c where c.customerId=?1)")
	public List<TripBooking> getAllTripBetweenDate(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate);

}
