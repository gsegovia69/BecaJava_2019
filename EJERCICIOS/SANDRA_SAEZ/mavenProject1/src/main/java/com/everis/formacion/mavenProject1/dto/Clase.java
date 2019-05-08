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

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Setter
@Getter
@ToString
@XStreamAlias("clase")

@Table(name="clase") 
public class Clase {
	
	private Profesor profesor;
	@Id
	@GeneratedValue
	@Column (name="id")
	private int idClase;
	
	@Column(name="nombre")
	private String nombreClase;

	
	
	
	@OneToMany(fetch =FetchType.EAGER, mappedBy="claseAlumno")
	private Set<Alumno> alumnos= new HashSet<Alumno>();
	
	@OneToMany(fetch =FetchType.EAGER, mappedBy="claseProfesor")
	private Set<Profesor> profesores= new HashSet<Profesor>();
	
	@OneToMany(fetch =FetchType.EAGER, mappedBy="claseAsignatura")
	private Set<Asignatura> asignaturas= new HashSet<Asignatura>();

}


