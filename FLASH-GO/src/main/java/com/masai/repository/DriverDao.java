package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Driver;

public interface DriverDao extends JpaRepository<Driver, Integer> {

}
