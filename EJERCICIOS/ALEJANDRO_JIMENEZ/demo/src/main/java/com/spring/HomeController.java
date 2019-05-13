package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.dto.AsignaturaDTO;
import com.spring.entities.Asignatura;
import com.spring.managers.AsignaturaManager;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;



@Getter
@Setter
@Log
@Controller
@ConfigurationProperties(prefix="home.controller")
public class HomeController {
	

	
	private String atributo = "Hola Mundo";

	
	/*
	@GetMapping("/prueba/{variable}")
	public String prueba(@PathVariable("variable") String variable, Model model) {
		AsignaturaDTO asignatura = miManager.getOneAsignatura(Long.parseLong(variable));
		model.addAttribute("asignatura",asignatura);
		return "hola";
	}*/
	
	@GetMapping("/")
	public String home() {
		log.info("Atributo " + atributo);
		return "home";
	}
	 
}
