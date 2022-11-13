
package com.masai.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CabException;
import com.masai.model.Cab;
import com.masai.model.CabType;
import com.masai.repository.CabDao;

@Service
public class CabServiceImp implements CabService {
	
	@Autowired
	private CabDao cDao;

	@Override
	public Cab insertCab(Cab cab) throws CabException {
		
		Cab c = cDao.save(cab);
		
		if(c==null) throw new CabException("Enter Valid Details...!");
		
		return c;
		
	}

	@Override
	public Cab updateCab(Cab cab) throws CabException {
		
		Optional<Cab> optional = cDao.findById(cab.getCabId());
		
		if(optional.isPresent()) {
			
			Cab updatedCab = cDao.save(cab);                 //merge
			
			return updatedCab;
		
		}else {
			throw new CabException("Cab details not present to updated the Cab");
		}

	}

	@Override
	public Cab deleteCab(Integer id) throws CabException {
		
		Optional<Cab> optional = cDao.findById(id);
		if(optional.isPresent()) {
			
			Cab d = optional.get();
			
			cDao.delete(d);
			
			return d;
			
		}else {
			throw new CabException("Cab not found with this Cab id" + id);
		}
	}

	@Override
	public List<Cab> viewCabsOfType(CabType cabType) throws CabException {
		
		List<Cab> cabList = cDao.getCabList(cabType);
		
		if(cabList.size()==0) throw new CabException("Cab Not Found With this Type...!");
		
		return cabList;
	}

	@Override
	public Integer countCabsOfType(CabType cabType) throws CabException{
		
		Integer num = cDao.countCabByType(cabType);
		
		if(num==null) throw new CabException("Cab Not Found With this Type...!");
		
		return num;
		
	}

}