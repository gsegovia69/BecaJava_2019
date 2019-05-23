package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.controller.Usuario;
import com.example.demo.dto.AlumnoDTO;
import com.example.demo.dto.AsignaturaDTO;
import com.example.demo.dto.CursoDTO;
import com.example.demo.dto.ProfesorDTO;
import com.example.demo.entities.AlumnoEntity;
import com.example.demo.manager.AlumnoManager;
import com.example.demo.manager.AsignaturaManager;
import com.example.demo.manager.CursoManager;
import com.example.demo.manager.ProfesorManager;

@Controller
public class Controller1 {
	boolean orden=true;

	@Autowired
	private AlumnoManager alumnoManager;
	@Autowired
	private ProfesorManager profesorManager;
	@Autowired
	private CursoManager cursoManager;
	@Autowired
	private AsignaturaManager asignaturaManager;

	@GetMapping(value = "/hola/{userName}")
	public String variable1(@PathVariable("userName") long variable1, Model model1) {
		Usuario user = new Usuario();
		user.setuserName("" + variable1);
		int userName = 0;
		model1.addAttribute(+userName);
		return "hola";
	}

	@RequestMapping(value = "/adios/{userName}")
	public String variable(@PathVariable("userName") String userName, Model model1) {
		model1.addAttribute("msg", "user id" + userName);
		return "adios";
	}

/////////////////// ALUMNO /////////////////////////////
	@GetMapping("/tablaListaAlumnos")
	public String listaAlumnos(@PageableDefault(size=10)Pageable pageable, Model model, @RequestParam(value="direccion", defaultValue = "1") Integer direccion) {
		Page<AlumnoEntity> alumnos = alumnoManager.numeroPagina(pageable);
		model.addAttribute("listaAlumnos", alumnos);
		model.addAttribute("direccion", direccion);
		return "tablaListaAlumnos";	
	}

	@GetMapping("/editarAlumno")
	public String editarAlumno(Long identificador, Model model) {
		AlumnoDTO alumno = new AlumnoDTO();
		if (identificador != null) {
			alumno = alumnoManager.giveOneAlumno(identificador);
		}
		alumno.setCursos(cursoManager.dameCurso());
		model.addAttribute("alumnos", alumno);
		return "editarAlumno";
	}
	@PostMapping("/guardarAlumno")
	public String guardarAlumno(AlumnoDTO alumno, Model model) {
		System.out.println(alumno.toString());
		alumnoManager.guardame(alumno);
		return "redirect:/tablaListaAlumnos";
	}
	@GetMapping("/borrarAlumno")
	public String borramelo(Long identificador) {
		AlumnoDTO alumno=alumnoManager.giveOneAlumno(identificador);
		alumnoManager.borramelo(alumno);
		return "redirect:/tablaListaAlumnos";
	}
	@GetMapping("/insertarAlumno")
	public String insertarAlumno(Long identificador, Model model) {
		AlumnoDTO alumno =new AlumnoDTO();
		if (identificador!=null) {
			alumno=alumnoManager.giveOneAlumno(identificador);
		}model.addAttribute("alumno", alumno);
		return "insertarAlumno";	
	}
	@GetMapping("/ordenarAlumno")
	public String ordenarAlumno(Model model, Integer direccion) {
		List<AlumnoDTO> alumnos=alumnoManager.ordenarAlumnoAsc();
		model.addAttribute("listaAlumnos", alumnos);
		model.addAttribute("direccion", direccion);
		return "tablaListaAlumnos";	
	}
	@GetMapping("/ordenarAlumnoDesc2")
	public String ordenarAlumnoDesc(Model model, Integer direccion) {
		List<AlumnoDTO> alumnos=alumnoManager.ordenarAlumnoDesc();
		model.addAttribute("listaAlumnos", alumnos);
		model.addAttribute("direccion", direccion);
		return "tablaListaAlumnos";
	}
//	@GetMapping("/ordenarALu")
//	public String ordenarAlu (@RequestParam Model model, Integer direccion)  {
//	if (orden==true) {
//		ordenarAlumno(model, direccion);
//		orden=false;
//	}else {
//		ordenarAlumnoDesc(model, direccion);
//	orden= true;
//	}return "tablaListaAlumnos";		
//	}
	
//	@GetMapping("/ordenarAlu")	
//	public String ordenarAlu (Model model,@RequestParam(value="direccion",defaultValue="1") Integer direccion) {
//		if(direccion!=0) {
//			List<AlumnoDTO> alumnos=alumnoManager.ordenarAlumnoAsc();
//			model.addAttribute("listaAlumnos", alumnos);
//			model.addAttribute("direccion", direccion);
//			return "tablaListaAlumnos";				
//		}else {
//			List<AlumnoDTO> alumnos=alumnoManager.ordenarAlumnoDesc();
//			model.addAttribute("listaAlumnos", alumnos);
//			model.addAttribute("direccion", direccion);
//			return "tablaListaAlumnos";
//		}				
//	}      
	
	
///////////////////// PROFESORES////////////////////////////////////
	@GetMapping("/tablaListaProfesores")
	public String listaProfesores(Model model) {
		List<ProfesorDTO> profesores = profesorManager.dameProfesor();
		model.addAttribute("listaProfesores", profesores);
		return "tablaListaProfesores";
	}

	@GetMapping("/editarProfesor")
	public String editarProfesor(Long identificador, Model model) {
		ProfesorDTO profesor =new ProfesorDTO();
		if (identificador!=null) {
			profesor=profesorManager.giveOneProfesor(identificador);
		}
		profesor.setCursos(cursoManager.dameCurso());
		model.addAttribute("profesores", profesor);
		return "editarProfesor";
	}
	@PostMapping("/guardarProfesor")
	public String guardarProfesor(ProfesorDTO profesor, Model model) {
		System.out.println(profesor.toString());
		profesorManager.guardame(profesor);
		return "redirect:/tablaListaProfesores";
	}
	@GetMapping("/borrarProfesor")
	public String borraProfesor(Long identificador) {
		ProfesorDTO profesor=profesorManager.giveOneProfesor(identificador);
		profesorManager.borraProfesor(profesor); 
		return "redirect:/tablaListaProfesores";
	}
	@GetMapping("/insertarProfesor")
	public String insertarProfesor(Long identificador, Model model) {
		ProfesorDTO profesor =new ProfesorDTO();
		if (identificador!=null) {
			profesor=profesorManager.giveOneProfesor(identificador);
		}model.addAttribute("profesor", profesor);
		return "insertarProfesor";		
	}
	
///////// ////////////////////// CURSOS/////////////////////////////////////
	@GetMapping("/tablaCursos")
	public String listaCursos(Model model) {
		List<CursoDTO> cursos = cursoManager.dameCurso();
		model.addAttribute("lista", cursos);
		return "tablaCursos";
	}

	@GetMapping("/editarCurso")
	public String editarCurso(@RequestParam Long identificador, Model model) {
		model.addAttribute("cursos", cursoManager.giveOneCurso(identificador));
		return "editarCurso";
	}

	@PostMapping("/guardarCurso")
		public String guardarCurso(CursoDTO curso, Model model) {
		System.out.println(curso.toString());
		cursoManager.guardame(curso);
		return "redirect:/tablaCursos";
	}

///////////////////////////////// ASIGNATURA//////////////////////////////////////////
	@GetMapping("/tablaAsignatura")
	public String listaAsignatura(Model model) {
		List<AsignaturaDTO> asignaturas = asignaturaManager.dameAsignatura();
		model.addAttribute("listaAsignatura", asignaturas);
		return "tablaAsignatura";
	}
	@GetMapping("/editarAsignatura")
	public String editarAsignatura(Long identificador, Model model) {
		AsignaturaDTO asignatura = new AsignaturaDTO();
		if (identificador != null) {
			asignatura = asignaturaManager.giveOneAsigantura(identificador);
		}
		asignatura.setCursos(cursoManager.dameCurso());
		model.addAttribute("asignaturas", asignatura);
		return "editarAsignatura";	
	}

	@PostMapping("/guardarAsignatura")
	public String guardarAsignatura(AsignaturaDTO asignatura, Model model) {
		System.out.println(asignatura.toString());
		asignaturaManager.guardame(asignatura);
		return "redirect:/tablaAsignatura";
	}
	@GetMapping("/borrarAsignatura")
	public String borraAsignatura(Long identificador) {
		AsignaturaDTO asignatura=asignaturaManager.giveOneAsigantura(identificador);
		asignaturaManager.borrameAsignatura(asignatura); 
		return "redirect:/tablaAsignatura";	
	}
	
	
}