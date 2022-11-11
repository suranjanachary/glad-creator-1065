package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Driver extends AbstractUser  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driverid;
	
	@NotNull
	@Pattern(regexp = "^(([A-Z]{2}[0-9]{2})( )|([A-Z]{2}-[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}$")
	private String licenceNo;
	
	@Embedded
	@OneToOne(cascade = CascadeType.ALL)
	private Cab cab;
	
	@NotNull
	@Pattern(regexp = "^[+-]?([0-9]*[.])?[0-9]+$")
	private float rating;
	
	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public Driver(
			@NotNull @Pattern(regexp = "^(([A-Z]{2}[0-9]{2})( )|([A-Z]{2}-[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}$") String licenceNo,
			Cab cab, @NotNull @Pattern(regexp = "^[+-]?([0-9]*[.])?[0-9]+$") float rating) {
		super();
		this.licenceNo = licenceNo;
		this.cab = cab;
		this.rating = rating;
	}

	public Integer getDriverid() {
		return driverid;
	}

	public void setDriverid(Integer driverid) {
		this.driverid = driverid;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Driver [driverid=" + driverid + ", licenceNo=" + licenceNo + ", rating=" + rating + "]";
	}
	
}
