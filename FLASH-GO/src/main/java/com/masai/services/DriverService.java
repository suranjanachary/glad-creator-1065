package com.masai.services;

import java.util.List;

import com.masai.model.Driver;

public interface DriverService {
	
	public Supplier insertDriver(Driver driver);
	
	public Supplier updateDriver(Driver driver);
	
	public Supplier deleteDriver(Integer driverId);
	
	public List<Driver> viewBestDrivers();
	
	public Driver viewDriver(Integer driverId);
	
}
