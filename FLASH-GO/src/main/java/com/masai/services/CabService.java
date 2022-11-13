package com.masai.services;

import java.util.List;

import com.masai.exception.CabException;
import com.masai.model.Cab;
import com.masai.model.CabType;

public interface CabService {
	
	public Cab insertCab(Cab cab) throws CabException;
	
	public Cab updateCab(Cab cab) throws CabException;
	
	public Cab deleteCab(Integer id) throws CabException;
	
	public List<Cab> viewCabsOfType(CabType carType) throws CabException;
	
	public Integer countCabsOfType(CabType carType) throws CabException;

}







