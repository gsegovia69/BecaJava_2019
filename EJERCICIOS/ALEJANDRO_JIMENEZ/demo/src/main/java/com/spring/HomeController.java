package com.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@ConfigurationProperties(prefix="home.controller")
public class HomeController {
	

	
	private String atributo = "Hola Mundo";
	@Autowired
	private AlumnoManager alumnoManager;
	
	@Autowired
	private ProfesorManager profesorManager;
	
	@Autowired
	private AsignaturaManager asignaturaManager;
	
	@Autowired
	private ClaseManager claseManager;
	
	@GetMapping("/home")
	public String home() {
		log.info("Atributo " + atributo);
		return "home";
	}
	
	@GetMapping("/lista/alumnos")
	public String listaAlumnos(Model model) {
		List<AlumnoDTO> alumnos = alumnoManager.getAlumnos();
		model.addAttribute("alumnos",alumnos);
		return "alumnos";
	}
	
	@GetMapping("/lista/profesores")
	public String listaProfesores(Model model) {
		List<ProfesorDTO> profesores = profesorManager.getProfesores();
		model.addAttribute("profesores",profesores);
		return "profesores";
	}
	
	@GetMapping("/lista/asignaturas")
	public String listaAsignaturas(Model model) {
		List<AsignaturaDTO> asignaturas = asignaturaManager.getAsignaturas();
		model.addAttribute("asignaturas",asignaturas);
		return "asignaturas";
	}
	
	@GetMapping("/lista/clases")
	public String listaClases(Model model) {
		List<ClaseDTO> clases = claseManager.getClases();
		model.addAttribute("clases",clases);
		return "clases";
	}
	
	@GetMapping("/editarAlumno")
	public String editarAlumno(@RequestParam Long idAlumno ,Model model) {
		AlumnoDTO alum =alumnoManager.getOneAlumno(idAlumno);
		model.addAttribute("alum",alum);
		return "editarAlumno";
	}
	
	@GetMapping("/editarProfesor")
	public String editarProfesor(@RequestParam Long idProfesor ,Model model) {
		ProfesorDTO prof =profesorManager.getOneProfesor(idProfesor);
		model.addAttribute("prof",prof);
		return "editarProfesor";
	}
	
	@GetMapping("/editarAsignatura")
	public String editarAsignatura(@RequestParam Long idAsignatura ,Model model) {
		AsignaturaDTO asig =asignaturaManager.getOneAsignatura(idAsignatura);
		model.addAttribute("asig",asig);
		return "editarAsignatura";
	}
	
	@GetMapping("/editarClase")
	public String editarClases(@RequestParam Long idClase ,Model model) {
		ClaseDTO clase =claseManager.getOneClase(idClase);
		model.addAttribute("clase",clase);
		return "editarClase";
	}
	
	@PostMapping("/alumno/edit")
	public String procesarEditarAlumno(@ModelAttribute AlumnoDTO alu,Model model) {
		alu.toString();
		alumnoManager.guardarAlumno(alu);
		return "alumnos";
	}
}
