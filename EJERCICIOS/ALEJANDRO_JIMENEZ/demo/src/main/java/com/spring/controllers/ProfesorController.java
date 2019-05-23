package com.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dto.AlumnoDTO;
import com.spring.dto.AsignaturaDTO;
import com.spring.dto.ProfesorDTO;
import com.spring.managers.ClaseManager;
import com.spring.managers.ProfesorManager;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;



@Getter
@Setter
@Log
@Controller
@ConfigurationProperties(prefix="profesor.controller")
public class ProfesorController {

	@Autowired
	private ProfesorManager profesorManager;
	
	@Autowired
	private ClaseManager claseManager;
	
	@GetMapping("/lista/profesores")
	public String listaProfesores(Model model) {
		List<ProfesorDTO> profesores = profesorManager.getProfesores();
		model.addAttribute("profesores",profesores);
		return "profesores/profesores";
	}
	
	@RequestMapping("/buscar/profesores")
	public String buscarProfesores(Model model, String sourceText) {
		
		List<ProfesorDTO> profesores = new ArrayList<>();
		if (sourceText==null) {
		profesores = profesorManager.getProfesores();
		}
		else {
		profesores = profesorManager.buscarNombre(sourceText);
		}
		model.addAttribute("profesores",profesores);
		return "profesores/profesores";
	}
	
	@GetMapping("/editarProfesor")
	public String editarProfesor( Long idProfesor ,Model model) {
		ProfesorDTO prof = new ProfesorDTO();
		if(idProfesor!=null) {
			prof =profesorManager.getOneProfesor(idProfesor);
		}
		prof.setListaClases(claseManager.getClases());
		model.addAttribute("prof",prof);
		return "profesores/editarProfesor";
	}
	
	@PostMapping("/profesor/edit")
	public String procesarEditarProfesor(@ModelAttribute ProfesorDTO prof,Model model) {
		profesorManager.guardarProfesor(prof);
		return "redirect:/lista/profesores";
	}
	
	@GetMapping("/borrarProfesor")
	public String borrarProfesor( Long idProfesor) {
		ProfesorDTO prof = new ProfesorDTO();		
		
		prof =profesorManager.getOneProfesor(idProfesor);

		 profesorManager.borrarProfesor(prof);
		
		return "redirect:/lista/profesores";
	}

}
