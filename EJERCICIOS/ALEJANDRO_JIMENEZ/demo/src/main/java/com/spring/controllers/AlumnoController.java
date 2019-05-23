package com.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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
import com.spring.dto.ClaseDTO;
import com.spring.dto.ProfesorDTO;
import com.spring.managers.AlumnoManager;
import com.spring.managers.ProfesorManager;
import com.spring.managers.AsignaturaManager;
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
	@Autowired
	private ProfesorManager profesorManager;
	@Autowired
	private AsignaturaManager asignaturaManager;
	
	@GetMapping("/home")
	public String home() {
		
		return "home";
	}
	
	@GetMapping("/destruir")
	public String destroy() {
		alumnoManager.getRepository().deleteAll();
		profesorManager.getRepository().deleteAll();
		asignaturaManager.getRepository().deleteAll();
		claseManager.getRepository().deleteAll();
		return "home";
	}
	

	
	private Log logger;
	
	private String mensaje;
	
	@GetMapping("/lista/alumnos")
	public String listaAlumnos(Model model) {
		List<AlumnoDTO> alumnos = alumnoManager.getAlumnos();
		model.addAttribute("alumnos",alumnos);
		return "alumnos/alumnos";
	}
	
	@GetMapping("/alumno/buscar")
	public String buscarLetra(Model model , String letra) {
		List<AlumnoDTO> alumnos = new ArrayList<>();
		
		alumnos = alumnoManager.buscarLetra(letra);
		
		model.addAttribute("alumnos",alumnos);
		return "alumnos/alumnos";
	}
	
	@RequestMapping("/buscar/alumnos")
	public String buscarAlumnos(Model model, String sourceText) {
		List<AlumnoDTO> alumnos = new ArrayList<>();
		if (sourceText==null) {
			alumnos = alumnoManager.getAlumnos();
		}
		else {
			alumnos = alumnoManager.buscarNombre(sourceText);	
		}

		model.addAttribute("alumnos",alumnos);
		return "alumnos/alumnos";
	}
	
	
	
	@GetMapping("/ordenarNombreAlumnos")
	public String listaOrdenadaNombre(Model model) {
		List<AlumnoDTO> alumnos = alumnoManager.ordenarNombreAsc();
		model.addAttribute("alumnos",alumnos);
		return "alumnos/alumnos";
	}
	
	@GetMapping("/ordenarApellidoAlumnos")
	public String listaOrdenadaApellido(Model model) {
		List<AlumnoDTO> alumnos = alumnoManager.ordenarApellidoAsc();
		model.addAttribute("alumnos",alumnos);
		return "alumnos/alumnos";
	}
	
	@GetMapping("/ordenarEmailAlumnos")
	public String listaOrdenadaEmail(Model model) {
		List<AlumnoDTO> alumnos = alumnoManager.ordenarEmailAsc();
		model.addAttribute("alumnos",alumnos);
		return "alumnos/alumnos";
	}
	
	@GetMapping("/ordenarCiudadAlumnos")
	public String listaOrdenadaCiudad(Model model) {
		List<AlumnoDTO> alumnos = alumnoManager.ordenarCiudadAsc();
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
	
	@RequestMapping("/buscarTodo")
	public String buscarTodo(String sourceText, Model model) {
		List<AlumnoDTO> alumnos = alumnoManager.buscarNombre(sourceText);
		List<ProfesorDTO> profesores = profesorManager.buscarNombre(sourceText);
		List<AsignaturaDTO> asignaturas = asignaturaManager.buscarNombre(sourceText);
		List<ClaseDTO> clases = claseManager.buscarNombre(sourceText);
		model.addAttribute("alumnos",alumnos);
		model.addAttribute("profesores",profesores);
		model.addAttribute("asignaturas",asignaturas);
		model.addAttribute("clases",clases);
		return "todo";
	}


}
	
	

