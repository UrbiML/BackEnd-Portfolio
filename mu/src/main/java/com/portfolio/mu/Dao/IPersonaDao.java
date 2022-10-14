package com.portfolio.mu.Dao;

import org.springframework.data.repository.CrudRepository;
import com.portfolio.mu.Entity.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Long> {
	
}
