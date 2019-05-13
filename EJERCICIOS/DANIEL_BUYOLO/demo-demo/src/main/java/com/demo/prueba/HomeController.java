package com.demo.prueba;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.prueba.entities.Alumno;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Controller
@Getter
@Setter
@ConfigurationProperties(prefix = "atrib.variable")
public class HomeController {

	private String atributo = "Hola mundo";
	
	@GetMapping("/home")
	public String home() {
		//log.info("Atributo: "+ atributo);
		return "home";
	}
	
	@GetMapping("/adios")
	public String adios() {
		return "adios";
	}
	
	@RequestMapping("home/{name}")
	public String hola(@PathVariable String name, Model map) {
//		Alumno alumno = new Alumno();
//		name = alumno.getNombreAlumno();
		map.addAttribute("mensaje", name);
		
		return "home";
	}
	
	@GetMapping("adios/{name}") 
	public String adios(@PathVariable String name, Model map) {
		map.addAttribute("mensaje", name);
		return "adios";
	}
	
}
