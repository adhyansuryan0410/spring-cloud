package com.example.photoapp.api.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {

	@NotNull(message = "first name cannot be empty")
	@Size(min=2, message="first name cannot be less than 2 letters")
	private String firstName;
	
	@NotNull(message = "last name cannot be empty")
	@Size(min=2, message="last name cannot be less than 2 letters")
	private String lastName;
	
	@Email
	@NotNull(message = "email cannot be empty")
	private String email;
	
	@NotNull(message = "password cannot be empty")
	@Size(min=8, max=16, message="password must be < 16 letters and > 8 letters")
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
