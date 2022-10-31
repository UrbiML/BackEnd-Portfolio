package com.portfolio.mu.Dto;

import javax.validation.constraints.NotBlank;

public class dtoHys {
	@NotBlank
	private String nombre;
	
	@NotBlank
	private int porcentaje;
	
	
	// Constructors
	public dtoHys() {
	}

	public dtoHys(@NotBlank String nombre, @NotBlank int porcentaje) {
		this.nombre = nombre;
		this.porcentaje = porcentaje;
	}
	
	
	// Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
}
