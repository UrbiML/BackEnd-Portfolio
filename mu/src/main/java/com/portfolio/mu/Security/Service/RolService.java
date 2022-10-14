package com.portfolio.mu.Security.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.mu.Security.Entity.Rol;
import com.portfolio.mu.Security.Dao.IRolDao;
import com.portfolio.mu.Security.Enums.RolNombre;

@Service
@Transactional
public class RolService {
	@Autowired
	IRolDao irolDao;
	
	public Optional<Rol> getByRolNombre(RolNombre rolNombre){
		return irolDao.findByRolNombre(rolNombre);
	}
	
	public void save(Rol rol) {
		irolDao.save(rol);
	}
}
