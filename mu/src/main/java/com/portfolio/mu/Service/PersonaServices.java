package com.portfolio.mu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.mu.Entity.Persona;
import com.portfolio.mu.Dao.IPersonaDao;

@Service
public class PersonaServices implements IPersonaService{
	@Autowired 	
	private IPersonaDao PersonaDao;
	
	@Override
	public List<Persona> findAll(){
		
		return (List<Persona>) PersonaDao.findAll();
	}

	@Override
	public void savePersona(Persona persona) {
		PersonaDao.save(persona);		
	}

	@Override
	public void deletePersona(Long id) {
		PersonaDao.deleteById(id);
		
	}
	
	@Override
	public Persona findPersona(Long id) {
		Persona persona = PersonaDao.findById(id).orElse(null);
		return persona;
	}
}
