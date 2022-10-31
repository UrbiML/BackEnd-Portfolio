package com.portfolio.mu.Security.Dto;


public class JwtDto {
	private String token;

	
	//Constructors
	
	public JwtDto() {
	}
	
	
	public JwtDto(String token) {
		this.token = token;
	}
	
	
	//Getters & Setters
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
