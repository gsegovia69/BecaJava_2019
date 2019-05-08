package com.everis.formacion.mavenProject1.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table (name="curso")
public class Curso {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int idCurso;
	
	@Column(name="nombre")
	private String nombreCurso;
	
	@OneToMany(fetch =FetchType.EAGER, mappedBy="cursoAlumno")
	private Set<Alumno> alumnos= new HashSet<Alumno>();
	
	@OneToMany(fetch =FetchType.EAGER, mappedBy="cursoProfesor")
	private Set<Profesor> profesores= new HashSet<Profesor>();
	
	@OneToMany(fetch =FetchType.EAGER, mappedBy="cursoAsignatura")
	private Set<Asignatura> asignaturas= new HashSet<Asignatura>();



}
