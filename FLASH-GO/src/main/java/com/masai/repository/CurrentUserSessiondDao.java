package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.CurrentUserSession;

@Repository
public interface CurrentUserSessiondDao extends JpaRepository<CurrentUserSession, Integer> {
	
	public Optional<CurrentUserSession>findByuserId(Integer id);
	
	public Optional<CurrentUserSession>findByuuid(String uuid);
}
