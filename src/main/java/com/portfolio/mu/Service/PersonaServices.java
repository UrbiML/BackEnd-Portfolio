package com.portfolio.mu.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.mu.Entity.Persona;
import com.portfolio.mu.Dao.IPersonaDao;

@Service
@Transactional
public class PersonaServices {
	@Autowired 	
	IPersonaDao personaDao;
	
    public List<Persona> list(){
        return personaDao.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return personaDao.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombre){
        return personaDao.findByNombre(nombre);
    }
    
    public void save(Persona persona){
    	personaDao.save(persona);
    }
    
    public void delete(int id){
    	personaDao.deleteById(id);
    }
    
    public boolean existsById(int id){
        return personaDao.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return personaDao.existsByNombre(nombre);
    }
}
