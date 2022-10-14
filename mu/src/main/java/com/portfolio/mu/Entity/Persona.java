package com.portfolio.mu.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="persona")

public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @NotNull
	 @Size(min = 1, max = 45, message = "No cumple con la longitud")
	 private String nombre;
	 
	 @NotNull
	 @Size(min = 1, max = 45, message = "No cumple con la longitud")
	 private String apellido;
	 
	 @Size(min = 1, max = 45, message = "No cumple con la longitud")
	 private String img;
	
	 
	 @Size(min = 1, max= 45, message = "No cumple con la longitud")
	 private String titulo;
	 
	 
	 @Size(min = 1, max= 500, message = "No cumple con la longitud")
	 private String acerca_de_mi;
	 
	 
	//Getter&Setters 
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getAcerca_de_mi() {
		return acerca_de_mi;
	}

	public void setAcerca_de_mi(String acerca_de_mi) {
		this.acerca_de_mi = acerca_de_mi;
	}


}

