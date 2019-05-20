package com.demo.prueba;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.ShowDetails;
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
import com.demo.prueba.dto.ClaseDTO;
import com.demo.prueba.dto.ProfesorDTO;
import com.demo.prueba.manager.AlumnoManager;
import com.demo.prueba.manager.AsignaturaManager;
import com.demo.prueba.manager.ClaseManager;
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
	
	@Autowired
	private ClaseManager claseManager;
	
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
		AlumnoDTO alumnoDto = new AlumnoDTO();
		
		if ( identificador != null && identificador.intValue() > 0) {
			alumnoDto = alumnoManager.dameUnAlumno(identificador);	
		}
		
		alumnoDto.setListaClase(claseManager.dameClases());
		model.addAttribute("alumnoDto", alumnoDto);
		
		return "introducirDatosAlumno";
	}
	
	@GetMapping("/borrarDatosAlumno")
	public String borrarDatosAlumno(@RequestParam Integer identificador, Model model) {
		if (identificador != null) {
			//alumnoManager.borraAlumno(identificador);
		} 
		
		return "redirect:/listaAlumnos";
	}
	
	@GetMapping("/listaAsignaturasAlumno")
	public String listaAsignaturasAlumno (@RequestParam Integer identificador, Model model) {
		AlumnoDTO alumnoDto = new AlumnoDTO();
		List<AsignaturaDTO> asignaturaDto = new ArrayList<AsignaturaDTO>();
				
		if ( identificador != null && identificador.intValue() > 0) {
			alumnoDto = alumnoManager.dameUnAlumno(identificador);	
			asignaturaDto = asignaturaManager.dameAsignaturasAlumno(alumnoDto.getIdClase());
		}
		
		//alumnoDto.setListaClase(claseManager.dameClases());
		model.addAttribute("alumnoDto", alumnoDto);
		model.addAttribute("asignaturaDto",asignaturaDto);
		
		return "/listaAsignaturasAlumno";
	}
	
	@PostMapping("/guardaDatosAlumno")
	public String guardaDatosAlumno(@Valid AlumnoDTO alumnoDto, Model model) {
		//System.out.println(alumnoDto.toString());
		alumnoManager.guardaAlumnoBaseDatos(alumnoDto);
		return "redirect:/listaAlumnos";
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
		//System.out.println(profesorDto.toString());
		profesorManager.guardaProfesorBaseDatos(profesorDto);
		return "redirect:/listaProfesores";
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
	
	@PostMapping("/guardaDatosAsignatura")
	public String guardaDatosAsignatura(@Valid AsignaturaDTO asignaturaDto, Model model) {
		//System.out.println(asignaturaDto.toString());
		asignaturaManager.guardaAsignaturaBaseDatos(asignaturaDto);
		return "redirect:/listaAsignaturas";
	}
	
	@GetMapping("/listaClases")
	public String listaClases(Model model ) {
		List<ClaseDTO> claseDto = claseManager.dameClases();
		
		model.addAttribute("claseDto", claseDto);
		return "listaClases";
	}
}
