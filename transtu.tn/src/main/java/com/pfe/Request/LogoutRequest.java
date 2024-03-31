package com.pfe.Request;

public class LogoutRequest {
	   private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LogoutRequest(String email) {
		
		this.email = email;
	}

	@Override
	public String toString() {
		return "LogoutRequest [email=" + email + "]";
	}

	public LogoutRequest() {
		
	}
	   
}