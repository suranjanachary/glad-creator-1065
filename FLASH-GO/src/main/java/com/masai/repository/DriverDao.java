package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Driver;

public interface DriverDao extends JpaRepository<Driver, Integer> {
	
	
	@Query("from Driver where rating >= 4.5")
	public List<Driver> getBestDriver();

}
