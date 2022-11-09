package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin extends AbstractUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}



	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + "]";
	}
	
	
	
}
