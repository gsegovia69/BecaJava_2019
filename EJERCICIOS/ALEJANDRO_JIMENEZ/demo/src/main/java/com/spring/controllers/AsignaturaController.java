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
import com.spring.managers.AsignaturaManager;
import com.spring.managers.ClaseManager;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;



@Getter
@Setter
@Log
@Controller
@ConfigurationProperties(prefix="asignatura.controller")
public class AsignaturaController {

	@Autowired
	private AsignaturaManager asignaturaManager;
	
	@Autowired
	private ClaseManager claseManager;
	
	@GetMapping("/lista/asignaturas")
	public String listaAsignaturas(Model model) {
		List<AsignaturaDTO> asignaturas = asignaturaManager.getAsignaturas();
		model.addAttribute("asignaturas",asignaturas);
		return "asignaturas/asignaturas";
	}
	
	@RequestMapping("/buscar/asignaturas")
	public String buscarAsignaturas(Model model, String sourceText) {
		List <AsignaturaDTO> asignaturas= new ArrayList<>();
		if (sourceText==null) {
			asignaturas = asignaturaManager.getAsignaturas();
		}
		asignaturas = asignaturaManager.buscarNombre(sourceText);
		model.addAttribute("asignaturas",asignaturas);
		return "asignaturas/asignaturas";
	}
	
	@GetMapping("/editarAsignatura")
	public String editarAsignatura( Long idAsignatura ,Model model) {
		AsignaturaDTO asig = new AsignaturaDTO();
		if(idAsignatura!=null) {
			asig =asignaturaManager.getOneAsignatura(idAsignatura);
		}
		asig.setListaClases(claseManager.getClases());
		model.addAttribute("asig",asig);
		return "asignaturas/editarAsignatura";
	}

	@PostMapping("/asignatura/edit")
	public String procesarEditarAsignatura(@ModelAttribute AsignaturaDTO asig,Model model) {
		asignaturaManager.guardarAsignatura(asig);
		return "redirect:/lista/asignaturas";
	}
	
	@GetMapping("/borrarAsignatura")
	public String borrarAsignatura( Long idAsignatura) {
		AsignaturaDTO asig = new AsignaturaDTO();		
		
		asig =asignaturaManager.getOneAsignatura(idAsignatura);

		 asignaturaManager.borrarAsignatura(asig);
		
		return "redirect:/lista/asignaturas";
	}

}
