package com.portfolio.mu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.portfolio.mu.Entity.Persona;
import com.portfolio.mu.Service.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://portfolio-f109e.web.app")
public class PersonaController {
	@Autowired IPersonaService PersonaService;
	
	@GetMapping("/persona")
	public List<Persona> idex(){
		
		return PersonaService.findAll();
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/persona/crear")
	public String createPersona(@RequestBody Persona persona){
		PersonaService.savePersona(persona);
		
		return "La persona fue creada correctamente";
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/persona/borrar/{id}")
	public String deletePersona(@PathVariable Long id){
		PersonaService.deletePersona(id);
		
		return "La persona fue eliminada correctamente";
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/persona/editar/{id}")
	public Persona editPersona(
			@PathVariable Long id,
			@RequestParam("nombre") String nuevoNombre,
			@RequestParam("apellido") String nuevoApellido,
			@RequestParam("img") String nuevoImg,
			@RequestParam("titulo") String nuevoTitulo,
			@RequestParam("acerca_de_mi") String nuevoAcerca_de_mi){
		Persona persona = PersonaService.findPersona(id);
		persona.setNombre(nuevoNombre);
		persona.setApellido(nuevoApellido);
		persona.setImg(nuevoImg);
		persona.setTitulo(nuevoTitulo);
		persona.setAcerca_de_mi(nuevoAcerca_de_mi);
		
		PersonaService.savePersona(persona);
		return persona;
	}
	
	
	@GetMapping("/persona/traer/perfil")
	public Persona findPersona() {
		return PersonaService.findPersona((long)1);
	}
	
}
