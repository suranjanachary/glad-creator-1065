package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class TripBooking {

	@Id
	private Integer tripBookingId;
	
	@Embedded
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customerId;
	
	@Embedded
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
	
	@NotNull
	private float distanceInKm;
	
	@NotNull
	private float bill;
	
	public TripBooking() {
		// TODO Auto-generated constructor stub
	}

	public TripBooking(Customer customerId, Driver driver, @NotNull String fromLocation, @NotNull String toLocation,
			@NotNull @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$") LocalDateTime fromDateTime,
			@NotNull @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$") LocalDateTime toDateTime, @NotNull boolean status,
			@NotNull float distanceInKm, @NotNull float bill) {
		super();
		this.customerId = customerId;
		this.driver = driver;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
	}

	public Integer getTripBookingId() {
		return tripBookingId;
	}

	public void setTripBookingId(Integer tripBookingId) {
		this.tripBookingId = tripBookingId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public LocalDateTime getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public float getDistanceInKm() {
		return distanceInKm;
	}

	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}

	public float getBill() {
		return bill;
	}

	public void setBill(float bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "TripBooking [tripBookingId=" + tripBookingId + ", customerId=" + customerId + ", driver=" + driver
				+ ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + ", fromDateTime=" + fromDateTime
				+ ", toDateTime=" + toDateTime + ", status=" + status + ", distanceInKm=" + distanceInKm + ", bill="
				+ bill + "]";
	}
	
	
	
}
