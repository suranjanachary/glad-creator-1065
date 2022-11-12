package com.masai.model;

import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class User {

	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]{3,25}", message = "length must be >=3")
	private String username;
	
	@NotNull
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$")
	private String password;
	
	@NotNull
	@Pattern(regexp = "[0-9][10]", message ="Mobile number must be 10 digits")
	private String mobile;
	
	@NotNull
	@Email
	private String email;
	

}
