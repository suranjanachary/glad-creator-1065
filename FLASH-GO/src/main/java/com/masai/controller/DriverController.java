package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.DriverException;
import com.masai.model.Customer;
import com.masai.model.Driver;
import com.masai.services.CustomerService;
import com.masai.services.DriverService;

@RestController
public class DriverController {

	@Autowired
	private DriverService driverService;
		
		@PostMapping("/regdriver")
		public ResponseEntity<Driver> regDriverHandler (@Valid @RequestBody Driver driver) throws DriverException{
			
			Driver driv= driverService.insertDriver(driver);
			 return new ResponseEntity<Driver>(driv, HttpStatus.CREATED);
		}
		
		@PutMapping("/updatedriver")
		public ResponseEntity<Driver> updateDriverHandler(@Valid @RequestBody Driver d1) throws DriverException{
			Driver updatedriver = driverService.updateDriver(d1);
			
			return new ResponseEntity <Driver>(updatedriver,HttpStatus.OK);
		}
		
		@DeleteMapping("/deletedriver/{id}")
		public ResponseEntity<Driver> deleteDriverByIdHandler( @PathVariable Integer id) throws DriverException{
			Driver deletedriver = driverService.deleteDriver(id);
			
			return new ResponseEntity <Driver>(deletedriver,HttpStatus.OK);
		}
		
		@GetMapping("/viewbestdrivers")
		public ResponseEntity<List<Driver>> getAllCustomerHandler() throws DriverException{
			List<Driver> employees = driverService.viewBestDrivers();
			
			return new ResponseEntity<List<Driver>>(employees,HttpStatus.OK);
		}
		
		@GetMapping("/getdriverbyid/{id}")
		public ResponseEntity<Driver> getDriverByAddAndNameHandler(@PathVariable Integer id) throws DriverException{
			Driver driver = driverService.viewDriver(id);
			
		   return new ResponseEntity<Driver>(driver,HttpStatus.OK);
		}
}
