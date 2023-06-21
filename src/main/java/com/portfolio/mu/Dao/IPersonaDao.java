package com.portfolio.mu.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.mu.Entity.Persona;

@Repository
public interface IPersonaDao extends JpaRepository<Persona, Integer> {
	Optional<Persona> findByNombre(String nombre);
	public boolean existsByNombre(String nombre);
}
