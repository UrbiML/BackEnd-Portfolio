package com.portfolio.mu.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.mu.Entity.HyS;


@Repository
public interface IhysDao extends JpaRepository<HyS, Integer> {
	Optional<HyS> findByNombre(String nombre);
	public boolean existsByNombre(String nombre);
}
