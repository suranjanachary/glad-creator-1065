package com.masai.services;

import java.util.List;

import com.masai.model.Cab;

public interface CabService {
	
	public Cab insertCab(Cab cab);
	
	public Cab updateCab(Cab cab);
	
	public Cab deleteCab(Cab Cab);
	
	public List<Cab> viewCabsOfType(String carType);
	
	public Integer countCabsOfType(String carType);

}
