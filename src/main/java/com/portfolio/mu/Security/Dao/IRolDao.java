package com.portfolio.mu.Security.Dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.mu.Security.Entity.Rol;
import com.portfolio.mu.Security.Enums.RolNombre;

@Repository
public interface IRolDao extends CrudRepository<Rol, Integer>{
	Optional<Rol> findByRolNombre(RolNombre rolNombre);

}
