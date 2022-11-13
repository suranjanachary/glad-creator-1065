package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cab {

	@Id
	@SequenceGenerator(name="cab_generator", sequenceName = "cab_seq", allocationSize=50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cab_generator")
	private Integer cabId;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private CabType cabType;
	
	@NotNull
	//@Pattern(regexp = "^(?:0|[1-9]\\d*)(?:\\.(?!.*000)\\d+)?$")
	private float perKmRate;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "cab")
	@JsonIgnore
	private Driver driver;
	
	@NotNull
	private boolean status;
}
