package com.portfolio.mu.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.mu.Dao.IProyectosDao;
import com.portfolio.mu.Entity.Proyectos;


@Service
public class ProyectosService {
	@Autowired
	IProyectosDao proyectosDao;
	
	  public List<Proyectos> list(){
        return proyectosDao.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
        return proyectosDao.findById(id);
    }
    
    public Optional<Proyectos> getByNombre(String nombre){
        return proyectosDao.findByNombre(nombre);
    }
    
    public void save(Proyectos proyectos){
    	proyectosDao.save(proyectos);
    }
    
    public void delete(int id){
    	proyectosDao.deleteById(id);
    }
    
    public boolean existsById(int id){
        return proyectosDao.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return proyectosDao.existsByNombre(nombre);
    }
}
