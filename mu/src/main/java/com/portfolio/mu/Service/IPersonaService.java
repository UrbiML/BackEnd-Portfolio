package com.portfolio.mu.Service;

import java.util.List;
import com.portfolio.mu.Entity.Persona;

public interface IPersonaService {
	
	public List<Persona> findAll();
	
	public void savePersona(Persona persona);
	
	public void deletePersona(Long id);
	
	public Persona findPersona(Long id);
}
