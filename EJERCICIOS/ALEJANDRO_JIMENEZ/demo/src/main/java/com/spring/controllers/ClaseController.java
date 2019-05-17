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
import com.spring.dto.AsignaturaDTO;
import com.spring.dto.ClaseDTO;
import com.spring.dto.ProfesorDTO;
import com.spring.managers.AlumnoManager;
import com.spring.managers.AsignaturaManager;
import com.spring.managers.ClaseManager;
import com.spring.managers.ProfesorManager;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;



@Getter
@Setter
@Log
@Controller
@ConfigurationProperties(prefix="clase.controller")
public class ClaseController {

	@Autowired
	private ClaseManager claseManager;
	
	@GetMapping("/lista/clases")
	public String listaClases(Model model) {
		List<ClaseDTO> clases = claseManager.getClases();
		model.addAttribute("clases",clases);
		return "clases/clases";
	}
	
	@GetMapping("/editarClase")
	public String editarClases(Long idClase ,Model model) {
		ClaseDTO clase = new ClaseDTO();		
		if(idClase!=null) {
			clase =claseManager.getOneClase(idClase);
		}
		else {
			clase.setId((long) claseManager.getClases().size() + 1 );
		}
		
		model.addAttribute("clase",clase);
		return "clases/editarClase";
	}
	
	@PostMapping("/clase/edit")
	public String procesarEditarClase(@ModelAttribute ClaseDTO clase,Model model) {
		claseManager.guardarClase(clase);
		return "redirect:/lista/clases";
	}
	
}
