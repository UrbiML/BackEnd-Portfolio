package com.portfolio.mu.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.mu.Dao.IhysDao;
import com.portfolio.mu.Entity.HyS;

@Transactional
@Service
public class Shys {
	@Autowired
	IhysDao iHys;
	
	public List<HyS> list(){
		return iHys.findAll();
	}
	
	public Optional<HyS> getOne(int id){
		return iHys.findById(id);
	}
	
	public Optional<HyS> getByNombre(String nombre){
		return iHys.findByNombre(nombre);
	}
	
	public void save(HyS skill) {
		iHys.save(skill);
	}
	
	public void delete(int id) {
		iHys.deleteById(id);
	}
	
	public boolean existsById(int id) {
		return iHys.existsById(id);
	}
	
	public boolean existsByNombre(String nombre) {
		return iHys.existsByNombre(nombre);
	}
}
