package com.portfolio.mu.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity

public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String nombre;
	 
	@NotNull
	private String apellido;
	 
	 
	private String img;
	
	 
	private String titulo;
	 
	 
	private String descripcion;
	 
	 
	// Constructors
	public Persona() {
	}
	
	

	public Persona(@NotNull String nombre, @NotNull String apellido, String img, String titulo, String descripcion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.img = img;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}



	//Getter&Setters 
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}

