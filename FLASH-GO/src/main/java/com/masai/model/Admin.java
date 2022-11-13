package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Admin extends User {

	@Id
	@SequenceGenerator(name="admin_generator", sequenceName = "admin_generator", allocationSize=100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_generator")
	private Integer adminId;
		
}
