package com.portfolio.mu.Controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.portfolio.mu.Dto.dtoPersona;
import com.portfolio.mu.Entity.Persona;
import com.portfolio.mu.Security.Controller.Mensaje;
import com.portfolio.mu.Service.*;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "http://localhost:4200")

public class PersonaController {
	@Autowired
	PersonaServices personaService;
	
	
	@GetMapping("/lista")
	public ResponseEntity<List<Persona>> list(){
		List<Persona> list = personaService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Persona> getById(@PathVariable("id") int id){
		if(!personaService.existsById(id)) {
			return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
	    }
	    Persona persona = personaService.getOne(id).get();
	    return new ResponseEntity(persona, HttpStatus.OK);
	}

	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
		if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        //Compara nombres
        if(personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Persona ya existente"), HttpStatus.BAD_REQUEST);
        
        //No puede estar vacio
        if(StringUtils.isBlank(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = personaService.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setTitulo(dtopersona.getTitulo());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setImg(dtopersona.getImg());
        
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizado"), HttpStatus.OK);
	}
}
	
