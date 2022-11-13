package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripBooking {

	//@SequenceGenerator(name="admin_generator", sequenceName = "admin_generator", allocationSize=100)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tripBookingId;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private Customer customerIds;
	

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Customer customer;

//	@ManyToOne(cascade = CascadeType.ALL)
//	private Customer customer;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Driver driver;
	
	@NotNull
	private String fromLocation;
	
	@NotNull
	private String toLocation;
	
	//@JsonFormat(pattern = "dd/mm/yyyy")
	@NotNull(message = "Format should be dd/mm/yyyy ")
	private String fromDateTime;
	
	//@JsonFormat(pattern = "dd/mm/yyyy")
	@NotNull(message = "Format should be dd/mm/yyyy ")
	private String toDateTime;
	
	@NotNull
	private boolean status;

	@NotNull
	private float distanceInKm;
	
	@NotNull
	private float bill;
	

}
