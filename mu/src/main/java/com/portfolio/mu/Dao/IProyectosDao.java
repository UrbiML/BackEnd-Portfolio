package com.portfolio.mu.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.mu.Entity.Proyectos;

@Repository
public interface IProyectosDao extends JpaRepository<Proyectos, Integer> {
	Optional<Proyectos> findByNombre(String nombre);
	public boolean existsByNombre(String nombre);
}
