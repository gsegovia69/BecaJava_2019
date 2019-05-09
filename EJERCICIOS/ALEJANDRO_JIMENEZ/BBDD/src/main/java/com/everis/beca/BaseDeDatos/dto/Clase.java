package com.everis.beca.BaseDeDatos.dto;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name="clase")
public class Clase {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	
	// Eager-> los carga directamente
	@OneToMany(mappedBy="claseAlumno" )
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	// Lazy-> solo los carga cuando utilice los datos.
	@OneToMany(mappedBy="claseProfesor")
	private List<Profesor> profesores = new ArrayList<Profesor>();

	@OneToMany(mappedBy="claseAsignatura")
	private List<Asignatura> asignaturas = new ArrayList<Asignatura>();
}

