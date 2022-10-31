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

import com.portfolio.mu.Dto.dtoEducacion;
import com.portfolio.mu.Entity.Educacion;
import com.portfolio.mu.Security.Controller.Mensaje;
import com.portfolio.mu.Service.EducacionService;


@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")

public class EducacionController {
	@Autowired 
	EducacionService sEducacion;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Educacion>> list(){
		List<Educacion> list = sEducacion.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/detail/{id}")
	   public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
	       if(!sEducacion.existsById(id)) {
	           return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
	       }
	       Educacion educacion = sEducacion.getOne(id).get();
	       return new ResponseEntity(educacion, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if(!sEducacion.existsById(id)) {
			return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
		}
		
		sEducacion.delete(id);
		return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
		if(StringUtils.isBlank(dtoeducacion.getNombreEdu())) 
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(dtoeducacion.getDescripcionEdu())) 
			return new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
		if(sEducacion.existsByNombreEdu(dtoeducacion.getNombreEdu())) 
			return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		
		Educacion educacion = new Educacion(dtoeducacion.getNombreEdu(), dtoeducacion.getDescripcionEdu());
		sEducacion.save(educacion);
		return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
		if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        //Compara nombres
        if(sEducacion.existsByNombreEdu(dtoeducacion.getNombreEdu()) && sEducacion.getByNombreEdu(dtoeducacion.getNombreEdu()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        
        //No puede estar vacio
        if(StringUtils.isBlank(dtoeducacion.getNombreEdu()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setNombreEdu(dtoeducacion.getNombreEdu());
        educacion.setDescripcionEdu((dtoeducacion.getDescripcionEdu()));
        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
	}
	
}
