package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Cab;
import com.masai.model.CabType;

@Repository
public interface CabDao extends JpaRepository<Cab, Integer>{
	
	@Query("from Cab where cabType = ?1")
	public List<Cab> getCabList(CabType cabType);
	
	@Query("select count(cabType) from Cab c where c.cabType = ?1")
	public Integer countCabByType(CabType cabType);

}
