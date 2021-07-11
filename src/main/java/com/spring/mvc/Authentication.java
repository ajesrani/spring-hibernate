package com.spring.mvc;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Authentication {
	
	//@NotEmpty
	@NotNull(message="Username should not be empty or null")
	@Size(min=6, max=12, message="Username must be between 6-12 characters")
	private String user;
	
	//@Pattern(regexp = "", message = "Invalid password")
	@MyAnnotation
	private String password;
	
	private Long passcode;

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getPasscode() {
		return passcode;
	}
	public void setPasscode(Long passcode) {
		this.passcode = passcode;
	}
	
	@Override
	public String toString() {
		return "Authentication [user=" + user + ", password=" + password + ", passcode=" + passcode + "]";
	}
	
}
