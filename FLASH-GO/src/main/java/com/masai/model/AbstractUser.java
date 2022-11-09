package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


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
	
	public AbstractUser() {
		// TODO Auto-generated constructor stub
	}

	public AbstractUser(@NotNull String username,
			@NotNull @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$") String password,
			@NotNull @Pattern(regexp = "[0-9][10]", message = "Mobile number must be 10 digits") String mobile,
			@NotNull @Email String email) {
		super();
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AbstractUser [username=" + username + ", password=" + password + ", mobile=" + mobile + ", email="
				+ email + "]";
	}

	
	
}
