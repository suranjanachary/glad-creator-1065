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

import com.masai.model.Cab;
import com.masai.model.Customer;
import com.masai.services.CabService;
import com.masai.services.CustomerService;

@RestController
public class CabController {
	
	@Autowired
	private CabService cabService;
		
		@PostMapping("/regcab")
		public ResponseEntity<Cab> regCabHandler (@Valid @RequestBody Cab c1) throws CabException{
			Cab cab= cabService.insertCab(c1);
			
			return new ResponseEntity<Cab>(cab, HttpStatus.CREATED);
		}
		
		@PutMapping("/updatecab")
		public ResponseEntity<Cab> updateCustomerHandler(@Valid @RequestBody Cab c1) throws CabException{
			Cab updateacb = cabService.updateCab(c1);
			
			return new ResponseEntity <Cab>(updateacb,HttpStatus.OK);
		}
		
		@DeleteMapping("/deletecab/{id}")
		public ResponseEntity<Cab> deleteCabByIdHandler( @PathVariable Integer id) throws CabException{
			Cab deletecab = cabService.deleteCab(id);
			
			return new ResponseEntity <Cab>(deletecab,HttpStatus.OK);
		}
		
		
		@GetMapping("/viewcabsoftype/{carType}")
		public ResponseEntity<List<Cab>> getCabsByTypeHandler(@PathVariable String carType) throws CabException{
			List<Cab> cabdata =cabService.viewCabsOfType(carType);
			
		   return new ResponseEntity<List<Cab>>(cabdata,HttpStatus.OK);
		}
		
		@GetMapping("/viewnoofcabsoftype/{type}")
		public ResponseEntity<Integer> getTotalCabsofTypeHandler(@PathVariable String carType) throws CabException{
			Integer cabs = cabService.countCabsOfType(carType);
			
			return new ResponseEntity<Integer>(cabs,HttpStatus.OK);
		}

}
