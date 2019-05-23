package com.example.demo.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AlumnoDTO {
	
	private Long id;
	private String nombreAlumno;
	private String apellidosAlumno;
	private String emailAlumno;
	private String ciudadAlumno;

	
	private CursoDTO id_curso;
	
	private List<CursoDTO> cursos;
	
	
}
