package com.spring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.AlumnoDTO;
import com.spring.managers.AlumnoManager;
import com.spring.managers.ClaseManager;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Getter
@Setter
@Controller
@ConfigurationProperties(prefix="alumno.controller")
public class AlumnoController {

	@Autowired
	private AlumnoManager alumnoManager;
	
	@Autowired
	private ClaseManager claseManager;
	
	private Log logger;
	
	private String mensaje;
	
	@GetMapping("/lista/alumnos")
	public String listaAlumnos(Model model) {
		List<AlumnoDTO> alumnos = alumnoManager.getAlumnos();
		model.addAttribute("alumnos",alumnos);
		return "alumnos/alumnos";
	}
	
	@GetMapping("/editarAlumno")
	public String editarAlumno( Long idAlumno ,Model model) {
		AlumnoDTO alum = new AlumnoDTO();		
		if(idAlumno!=null) {
			alum =alumnoManager.getOneAlumno(idAlumno);
		}
		alum.setListaClases(claseManager.getClases());
		model.addAttribute("alum",alum);
		
		return "alumnos/editarAlumno";
	}
	
	private void establecerMensaje(String texto) {
		if ( texto == null) {
			mensaje = "";
		}
		else
			mensaje = texto;
	}

	
	@PostMapping("/alumno/edit")
	public String procesarEditarAlumno(@Valid @ModelAttribute AlumnoDTO alu,Model model) {
		establecerMensaje(null);
		alumnoManager.guardarAlumno(alu);
		establecerMensaje("Guardado correctamente");
		model.addAttribute("mensaje",mensaje);
		return "redirect:/lista/alumnos";
	}
	
	@GetMapping("/borrarAlumno")
	public String borrarAlumno( Long idAlumno) {
		AlumnoDTO alum = new AlumnoDTO();		
		
		alum =alumnoManager.getOneAlumno(idAlumno);

		 alumnoManager.borrarAlumno(alum);
		
		return "redirect:/lista/alumnos";
	}
}
