package com.pratham.blogapp.Payloads;

import java.io.Serializable;

/**
 * 
 */
public class JwtResponse implements Serializable {

	private String token;
	
	private String username;

	public JwtResponse() {
		
	}

	public JwtResponse(String token, String username) {
		super();
		this.token = token;
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
