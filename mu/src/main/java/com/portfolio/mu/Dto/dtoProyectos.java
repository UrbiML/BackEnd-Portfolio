package com.portfolio.mu.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProyectos {
	
	@NotBlank
	private String nombre;
	@NotBlank 
	private String descripcion;
	
	// Constructors
	public dtoProyectos() {
	}


	public dtoProyectos(@NotBlank String nombre, @NotBlank String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	
	// Getters & Setters
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
