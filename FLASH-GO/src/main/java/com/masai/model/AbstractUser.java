package com.masai.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AbstractUser {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
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
