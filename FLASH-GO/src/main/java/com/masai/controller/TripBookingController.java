package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.masai.exception.TripBookingException;
import com.masai.model.TripBooking;
import com.masai.services.TripBookingService;

@RestController
public class TripBookingController {

	@Autowired
	private TripBookingService tbs;
	
	@PostMapping("/book/trip/{cid}")
	public ResponseEntity<TripBooking> regTripBookingHandler (@Valid @RequestBody TripBooking tripbooking,@PathVariable Integer cid) throws TripBookingException{
		
		 TripBooking tb = tbs.insertTripBooking(tripbooking,cid);
		 return new ResponseEntity<TripBooking>(tb, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/trip")
	
	    public ResponseEntity<TripBooking> updateTripHandler(@Valid @RequestBody TripBooking tripbooking) throws TripBookingException{
		TripBooking tb = tbs.updateTripBooking(tripbooking);
		
		return new ResponseEntity <TripBooking>(tb,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/trip/{id}")
	public ResponseEntity<TripBooking> deleteTripByIdHandler( @PathVariable Integer id) throws TripBookingException{
		TripBooking tb = tbs.deleteTripBooking(id);
		
		return new ResponseEntity <TripBooking>(tb,HttpStatus.OK);
	}
	
	@GetMapping("/view/trips/{id}")
	public ResponseEntity<List<TripBooking>> getAllTripsOfCustomerHandler(@PathVariable Integer id) throws TripBookingException{
		List<TripBooking> trips = tbs.viewAllTripsCustomer(id);
		
		return new ResponseEntity<List<TripBooking>>(trips,HttpStatus.OK);
	}
	
	@GetMapping("/get/bill/{id}/{tripId}")
	public ResponseEntity<TripBooking> getBillHandler(@PathVariable Integer id,@PathVariable Integer tripId) throws TripBookingException{
		TripBooking bill = tbs.calculateBill(id, tripId);
		
		return new ResponseEntity<TripBooking>(bill,HttpStatus.OK);
	}
	
}
