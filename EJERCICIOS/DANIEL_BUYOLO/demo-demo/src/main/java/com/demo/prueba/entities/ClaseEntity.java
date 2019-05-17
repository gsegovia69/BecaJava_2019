package com.demo.prueba.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clase")
public class ClaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int idClase;
	@Column(name = "nombre")
	private String nombreClase;
	
	@OneToMany(mappedBy = "claseAlumno" )
	private Set<AlumnoEntity> alumnos = new HashSet<AlumnoEntity>();
	
	@OneToMany(mappedBy = "claseProfesor" )
	private Set<ProfesorEntity> profesores = new HashSet<ProfesorEntity>();
	
	@OneToMany(mappedBy = "claseAsignatura" )
	private Set<AsignaturaEntity> asignaturas = new HashSet<AsignaturaEntity>();
	
}