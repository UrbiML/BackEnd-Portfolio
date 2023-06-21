package com.portfolio.mu.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.mu.Dao.IEducacionDao;
import com.portfolio.mu.Entity.Educacion;

@Service
@Transactional
public class EducacionService {
	@Autowired
	IEducacionDao iEducacion;
	
	public List<Educacion> list(){
		return iEducacion.findAll();
	}
	
	public Optional<Educacion> getOne(int id){
		return iEducacion.findById(id);
	}
	
	public Optional<Educacion> getByNombreEdu(String nombreEdu){
		return iEducacion.findByNombreEdu(nombreEdu);
	}
	
	public void save(Educacion educacion) {
		iEducacion.save(educacion);
	}
	
	public void delete(int id) {
		iEducacion.deleteById(id);
	}
	
	public boolean existsById(int id) {
		return iEducacion.existsById(id);
	}
	
	public boolean existsByNombreEdu(String nombreEdu) {
		return iEducacion.existsByNombreEdu(nombreEdu);
	}
}