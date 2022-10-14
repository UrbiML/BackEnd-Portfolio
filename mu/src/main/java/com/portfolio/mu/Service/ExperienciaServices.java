package com.portfolio.mu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.mu.Dao.IExperienciaDao;
import com.portfolio.mu.Entity.Experiencia;

@Service
public class ExperienciaServices implements IExperienciaService {
	@Autowired
	private IExperienciaDao ExperienciaDao;
	
	
	@Override
	public List<Experiencia> findAll() {
		return (List<Experiencia>) ExperienciaDao.findAll();
	}

	@Override
	public void saveExperiencia(Experiencia experiencia) {
		ExperienciaDao.save(experiencia);
		
	}

	@Override
	public void deleteExperiencia(Long id) {
		ExperienciaDao.deleteById(id);
		
	}

	@Override
	public Experiencia findExperiencia(Long id) {
		Experiencia experiencia = ExperienciaDao.findById(id).orElse(null);
		return experiencia;
	}	
}
