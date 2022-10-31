package com.portfolio.mu.Controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.portfolio.mu.Dto.dtoHys;
import com.portfolio.mu.Entity.HyS;
import com.portfolio.mu.Security.Controller.Mensaje;
import com.portfolio.mu.Service.Shys;

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "http://localhost4200")
public class HysController {

	@Autowired
	Shys shys;
	
	@GetMapping("/lista")
	public ResponseEntity<List<HyS>> list(){
		List<HyS> list = shys.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<HyS> getById(@PathVariable("id") int id){
	    if(!shys.existsById(id)) {
	        return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
	    }
	    HyS hys = shys.getOne(id).get();
	    return new ResponseEntity(hys, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if(!shys.existsById(id)) {
			return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
		}
		
		shys.delete(id);
		return new ResponseEntity(new Mensaje("Hard & Skill eliminada"), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody dtoHys dtohys){
		if(StringUtils.isBlank(dtohys.getNombre())) 
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(shys.existsByNombre(dtohys.getNombre())) 
			return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		
		HyS hys = new HyS(dtohys.getNombre(), dtohys.getPorcentaje());
		shys.save(hys);
		return new ResponseEntity(new Mensaje("Hard & Skill creada"), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHys dtohys){
		if(!shys.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        //Compara nombre de Skills
        if(shys.existsByNombre(dtohys.getNombre()) && shys.getByNombre(dtohys.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Hard & Skill ya existente"), HttpStatus.BAD_REQUEST);
        
        //No puede estar vacio
        if(StringUtils.isBlank(dtohys.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        HyS hys = shys.getOne(id).get();
        hys.setNombre(dtohys.getNombre());
        hys.setPorcentaje((dtohys.getPorcentaje()));
        
        shys.save(hys);
        return new ResponseEntity(new Mensaje("Hard & Skill actualizado"), HttpStatus.OK);
	}
}
