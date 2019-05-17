package com.spring.controllers;

import java.util.List;

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
@Log
@Controller
@ConfigurationProperties(prefix="alumno.controller")
public class AlumnoController {

	@Autowired
	private AlumnoManager alumnoManager;
	
	@Autowired
	private ClaseManager claseManager;
	
	@GetMapping("/lista/alumnos")
	public String listaAlumnos(Model model) {
		List<AlumnoDTO> alumnos = alumnoManager.getAlumnos();
		model.addAttribute("alumnos",alumnos);
		return "alumnos/alumnos";
	}
	
	@GetMapping("/editarAlumno")
	public String editarAlumno(@RequestParam Long idAlumno ,Model model) {
		AlumnoDTO alum =alumnoManager.getOneAlumno(idAlumno);
		alum.setListaClases(claseManager.getClases());
		model.addAttribute("alum",alum);
		return "alumnos/editarAlumno";
	}
	
	@PostMapping("/alumno/edit")
	public String procesarEditarAlumno(@ModelAttribute AlumnoDTO alu,Model model) {
		alumnoManager.guardarAlumno(alu);
		return "redirect:/lista/alumnos";
	}
}
