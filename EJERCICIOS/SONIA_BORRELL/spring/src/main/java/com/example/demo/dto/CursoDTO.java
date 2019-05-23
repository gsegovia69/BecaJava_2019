package com.example.demo.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CursoDTO {
	
	private Long id;
	private String nombre;
	
	private Set<AlumnoDTO> alumnos = new HashSet<AlumnoDTO>();
	private Set<ProfesorDTO> profesor = new HashSet<ProfesorDTO>();
	private Set<AsignaturaDTO> asignaturas = new HashSet<AsignaturaDTO>();
}
