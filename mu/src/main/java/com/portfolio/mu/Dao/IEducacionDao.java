package com.portfolio.mu.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.mu.Entity.Educacion;

@Repository
public interface IEducacionDao extends JpaRepository<Educacion, Integer> {
	public Optional<Educacion> findByNombreEdu(String nombreEdu);
	public boolean existsByNombreEdu(String nombreEdu);
}
