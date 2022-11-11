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
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Data
public class Driver extends AbstractUser  {

	@Id
	@SequenceGenerator(name="driver_generator", sequenceName = "driver_seq", allocationSize=50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_generator")
	private Integer driverid;
	
	@NotNull
	@Pattern(regexp = "^(([A-Z]{2}[0-9]{2})( )|([A-Z]{2}-[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}$")
	private String licenceNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cab cab;
	
	@NotNull
	@Pattern(regexp = "^[+-]?([0-9]*[.])?[0-9]+$")
	private float rating;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<TripBooking> tripList =  new ArrayList<>();
}
