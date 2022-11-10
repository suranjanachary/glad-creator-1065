package com.masai.services;

import java.util.List;

import com.masai.model.Driver;

public interface DriverService {
	
	public Supplier insertDriver(Driver driver) throws DriverException;
	
	public Supplier updateDriver(Driver driver) throws DriverException;
	
	public Supplier deleteDriver(Integer driverId) throws DriverException;
	
	public List<Driver> viewBestDrivers() throws DriverException;
	
	public Driver viewDriver(Integer driverId) throws DriverException;
	
}
