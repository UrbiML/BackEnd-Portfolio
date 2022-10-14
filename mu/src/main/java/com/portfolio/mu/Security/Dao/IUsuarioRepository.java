package com.portfolio.mu.Security.Dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.mu.Security.Entity.Usuario;

@Repository
public interface IUsuarioRepository  extends CrudRepository<Usuario, Integer>{
	Optional<Usuario> findByNombreUsuario(String nombreUsuario);
	
	boolean existsByNombreUsuario(String nombreUsuario);
	boolean existsByEmail(String email);
}
