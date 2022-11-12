package com.masai.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exception.DriverException;
import com.masai.model.Driver;

@Service
public class DriverServiceImp implements DriverService {

	@Override
	public Driver insertDriver(Driver driver) throws DriverException{
		
		return null;
	}

	@Override
	public Driver updateDriver(Driver driver) throws DriverException{
		
		return null;
	}

	@Override
	public Driver deleteDriver(Integer driverId) throws DriverException{
		
		return null;
	}

	@Override
	public List<Driver> viewBestDrivers() throws DriverException{
		
		return null;
	}

	@Override
	public Driver viewDriver(Integer driverId) throws DriverException{
		
		return null;
	}

}
