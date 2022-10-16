package com.portfolio.mu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.mu.Entity.Experiencia;
import com.portfolio.mu.Service.IExperienciaService;

@RestController
@CrossOrigin(origins = "https://portfolio-f109e.web.app")

public class ExperienciaController {
	@Autowired IExperienciaService ExperienciaService;
	
	@GetMapping("/Experiencia")
	public List<Experiencia> idex(){
		return ExperienciaService.findAll();
	}
	
	@PostMapping("/Experiencia/crear")
	public String createExperiencia(@RequestBody Experiencia experiencia){
		ExperienciaService.saveExperiencia(experiencia);
		
		return "El trabajo fue creada correctamente";
	}
	
	@PostMapping("/Experiencia/borrar")
	public String deleteExperiencia(@RequestBody Long id){
		ExperienciaService.deleteExperiencia(id);
		
		return "El trabajo fue eliminado correctamente";
	}
	
	@PutMapping("/Experiencia/editar/{id}")
	public Experiencia editExperiencia(
			@PathVariable Long id,
			@RequestParam("nombreE") String nuevoNombre,
			@RequestParam("descripcionE") String nuevaDescripcionE){
		Experiencia experiencia = ExperienciaService.findExperiencia(id);
		experiencia.setNombreE(nuevoNombre);
		experiencia.setDescripcionE(nuevaDescripcionE);		
		
		ExperienciaService.saveExperiencia(experiencia);
		return experiencia;
	}
}
