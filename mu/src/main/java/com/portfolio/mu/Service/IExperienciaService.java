package com.portfolio.mu.Service;

import java.util.List;

import com.portfolio.mu.Entity.Experiencia;

public interface IExperienciaService {
	public List<Experiencia> findAll();
	
	public void saveExperiencia(Experiencia experiencia);
	
	public void deleteExperiencia(Long id);
	
	public Experiencia findExperiencia(Long id);  
}
