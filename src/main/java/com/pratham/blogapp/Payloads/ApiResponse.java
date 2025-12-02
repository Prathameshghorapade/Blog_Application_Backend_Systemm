package com.pratham.blogapp.Payloads;


public class ApiResponse {

	String message;
	boolean statuse;
	
	
	public ApiResponse(String message, boolean statuse) {
		super();
		this.message = message;
		this.statuse = statuse;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatuse() {
		return statuse;
	}
	public void setStatuse(boolean statuse) {
		this.statuse = statuse;
	}
	

}
