package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TripBooking {

	@Id
	@SequenceGenerator(name = "trip_generator", sequenceName = "trip_sequence", allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trip_generator")
	private Integer tripBookingId;
	
	@Embedded
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customerIds;
	
//	@Embedded
//	private Integer customerId;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Driver driver;
	
	@NotNull
	private String fromLocation;
	
	@NotNull
	private String toLocation;
	
	@NotNull
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
	private LocalDateTime fromDateTime;
	
	@NotNull
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
	private LocalDateTime toDateTime;
	
	@NotNull
	private boolean status;
<<<<<<< HEAD
	
=======

>>>>>>> 91cb307362d517c35e3d60276583d70c5b599224
	@NotNull
	private float distanceInKm;
	
	@NotNull
	private float bill;
	

}
