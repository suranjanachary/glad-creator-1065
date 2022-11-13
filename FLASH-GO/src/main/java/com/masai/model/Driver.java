package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Driver extends User  {

	@Id
	@SequenceGenerator(name="driver_generator", sequenceName = "driver_seq", allocationSize=50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_generator")
	private Integer driverid;
	
	@NotNull
	//@Pattern(regexp = "^(([A-Z]{2}[0-9]{4})$")
	private String licenceNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cab cab;
	
	
	@NotNull
	//@Pattern(regexp = "^[+-]?([0-9]*[.])?[0-9]+$")
	private float rating;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "driver")
	List<TripBooking> tripList =  new ArrayList<>();
}
