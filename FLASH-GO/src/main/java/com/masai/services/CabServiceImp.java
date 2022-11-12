package com.masai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CabException;
import com.masai.model.Cab;
import com.masai.model.Driver;
import com.masai.repository.CabDao;
import com.masai.repository.DriverDao;

@Service
public class CabServiceImp implements CabService {

	@Autowired
	private CabDao cdao;
	
	@Autowired
	private DriverDao ddao;
	
	@Override
	public Cab insertCab(Cab cab) throws CabException {
		Cab c= cdao.save(cab);
		
		if(c==null) {
			throw new CabException("Null value can't be inserted to register a cab");
		}
		
		return null;
	}

	@Override
	public Cab updateCab(Cab cab) throws CabException {
		
		return null;
	}

	@Override
	public Cab deleteCab(Integer id) throws CabException {
		
		return null;
	}

	@Override
	public List<Cab> viewCabsOfType(String carType) throws CabException {
		
		return null;
	}

	@Override
	public Integer countCabsOfType(String carType) throws CabException{
		
		return null;
	}

}
