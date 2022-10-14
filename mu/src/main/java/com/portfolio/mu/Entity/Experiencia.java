package com.portfolio.mu.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "Experiencia_laboral")

public class Experiencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombreE;
	
	private String descripcionE;
	
	//Constructors
	public Experiencia() {
		
	}
	
	
	public Experiencia(String nombreE, String descripcionE) {
		this.nombreE = nombreE;
		this.descripcionE = descripcionE;
	}


	//Getters&Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreE() {
		return nombreE;
	}

	public void setNombreE(String nombreE) {
		this.nombreE = nombreE;
	}

	public String getDescripcionE() {
		return descripcionE;
	}

	public void setDescripcionE(String descripcionE) {
		this.descripcionE = descripcionE;
	}
	
	
}
