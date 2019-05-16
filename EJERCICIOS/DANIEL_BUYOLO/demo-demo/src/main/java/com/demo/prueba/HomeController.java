package com.demo.prueba;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.prueba.dto.AlumnoDTO;
import com.demo.prueba.dto.AsignaturaDTO;
import com.demo.prueba.dto.ProfesorDTO;
import com.demo.prueba.manager.AlumnoManager;
import com.demo.prueba.manager.AsignaturaManager;
import com.demo.prueba.manager.ProfesorManager;

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
	
	@Autowired
	private AlumnoManager alumnoManager;
	
	@Autowired
	private ProfesorManager profesorManager;
	
	@Autowired
	private AsignaturaManager asignaturaManager;
	
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
		map.addAttribute("mensaje", name);
		
		return "home";
	}
	
	@GetMapping("adios/{name}") 
	public String adios(@PathVariable String name, Model map) {
		map.addAttribute("mensaje", name);
		return "adios";
	}
	
	@GetMapping("/listaAlumnos")
	public String listaAlumnos(Model model ) {
		List<AlumnoDTO> alumnoDto = alumnoManager.dameAlumnos();
		model.addAttribute("alumnoDto", alumnoDto);
		return "listaAlumnos";
	}
	
	@GetMapping("/introducirDatosAlumno")
	public String introducirDatos(@RequestParam Integer identificador, Model model) {
		model.addAttribute("alumnoDto", alumnoManager.dameUnAlumno(identificador));
		return "introducirDatosAlumno";
	}
	
	@PostMapping("/guardaDatosAlumno")
	public String guardaDatosAlumno(@Valid AlumnoDTO alumnoDto, Model model) {
		System.out.println(alumnoDto.toString());
		alumnoManager.guardaAlumnoBaseDatos(alumnoDto);
		return listaAlumnos(model);
	}
	
	@GetMapping("/listaProfesores")
	public String listaProfesores(Model model ) {
		List<ProfesorDTO> profesorDto = profesorManager.dameProfesores();
		model.addAttribute("profesorDto", profesorDto);
		return "listaProfesores";
	}
	
	@GetMapping("/introducirDatosProfesor")
	public String introducirDatosProfesor(@RequestParam Integer identificador, Model model) {
		model.addAttribute("profesorDto", profesorManager.dameUnProfesor(identificador));
		return "introducirDatosProfesor";
	}
	
	@PostMapping("/guardaDatosProfesor")
	public String guardaDatosProfesor(@Valid ProfesorDTO profesorDto, Model model) {
		System.out.println(profesorDto.toString());
		profesorManager.guardaProfesorBaseDatos(profesorDto);
		return listaProfesores(model);
	}
	
	@GetMapping("/listaAsignaturas")
	public String listaAsignaturas(Model model ) {
		List<AsignaturaDTO> asignaturaDto = asignaturaManager.dameAsignaturas();
		model.addAttribute("asignaturaDto", asignaturaDto);
		return "listaAsignaturas";
	}
	
	@GetMapping("/introducirDatosAsignatura")
	public String introducirDatosAsignatura(@RequestParam Integer identificador, Model model) {
		model.addAttribute("asignaturaDto", asignaturaManager.dameUnaAsignatura(identificador));
		return "introducirDatosAsignatura";
	}
}