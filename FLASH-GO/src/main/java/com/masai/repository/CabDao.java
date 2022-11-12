package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Cab;

public interface CabDao extends JpaRepository<Cab, Integer>{
	
	@Query("from Cab where carType = ?1")
	public List<Cab> getCabList(String cabType);
	
	@Query("select count(cabType) from Cab c where c.cabType = ?1")
	public Integer countCabByType(String cabType);

}
