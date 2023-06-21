package com.portfolio.mu.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
	@NotBlank
	private String nombreEdu;
	@NotBlank
	private String descripcionEdu;
	
	// Constructors
	public dtoEducacion() {
	}

	public dtoEducacion(@NotBlank String nombreEdu, @NotBlank String descripcionEdu) {
		this.nombreEdu = nombreEdu;
		this.descripcionEdu = descripcionEdu;
	}

	
	// Getters & Setters
	
	public String getNombreEdu() {
		return nombreEdu;
	}

	public void setNombreEdu(String nombreEdu) {
		this.nombreEdu = nombreEdu;
	}

	public String getDescripcionEdu() {
		return descripcionEdu;
	}

	public void setDescripcionEdu(String descripcionEdu) {
		this.descripcionEdu = descripcionEdu;
	}
		
}
