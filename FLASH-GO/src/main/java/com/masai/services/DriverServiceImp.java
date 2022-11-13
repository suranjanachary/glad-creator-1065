package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.exception.DriverException;
import com.masai.model.Cab;
import com.masai.model.Driver;
import com.masai.repository.CabDao;
import com.masai.repository.DriverDao;

@Service
public class DriverServiceImp implements DriverService {
	
	@Autowired
	private DriverDao dDao;
	
	@Autowired
	private CabDao cDao;

	@Override
	public Driver insertDriver(Driver driver) throws DriverException{
		
		//Driver d = dDao.save(driver);
		
		
		List<Cab> cabList = cDao.findAll();
		
		if(cabList.size()==0) throw new DriverException("No Cab Left For Driver..!");
		
		for(Cab c:cabList) {
			if(c.isStatus()==false) {
				c.setStatus(true);
				driver.setCab(c);
				c.setDriver(driver);
				break;
			}
		}
		
		if(driver.getCab()==null) throw new DriverException("No Cab Left For Driver..!");
		Driver d = dDao.save(driver);
		if(d==null) throw new DriverException("Please Fill Proper Details..!");
		
		return d;
	}

	@Override
	public Driver updateDriver(Driver driver) throws DriverException{
		
		Optional<Driver> optional = dDao.findById(driver.getDriverid());
		
		if(optional.isPresent()) {
			
			Driver updatedDriver = dDao.save(driver);                 //merge
			
			updatedDriver.setCab(optional.get().getCab());
			
			//updatedDriver.setCab(driver.getCab());
			
			return updatedDriver;
		
		}else {
			throw new DriverException("Driver details not present to updated the Driver");
		}
	}

	@Override
	public Driver deleteDriver(Integer driverId) throws DriverException{
		Optional<Driver> optional = dDao.findById(driverId);
		if(optional.isPresent()) {
			
			Driver d = optional.get();
			
			d.getCab().setStatus(false);
			
			dDao.delete(optional.get());
			
			return d;
			
		}else {
			throw new DriverException("Driver not found with this Driver id" + driverId);
		}
	}

	@Override
	public List<Driver> viewBestDrivers() throws DriverException{
		
		List<Driver> bestDriverList = dDao.getBestDriver();
		
		if(bestDriverList.size()==0) throw new DriverException("Driver not found above rating 4.5 ...!");
		
		return bestDriverList;
	}

	@Override
	public Driver viewDriver(Integer driverId) throws DriverException{
		
		Optional<Driver> op  = dDao.findById(driverId);
		
		if(op.isEmpty()) throw new DriverException("Driver not found...!");
		
		return op.get();
		
	}

}
