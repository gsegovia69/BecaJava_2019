package com.spring.entities;



import java.util.ArrayList;
import java.util.List;

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
@Table(name="clase")
public class ClaseEntity {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	
	// Eager-> los carga directamente
	@OneToMany(mappedBy="claseAlumno" )
	private List<AlumnoEntity> alumnos = new ArrayList<AlumnoEntity>();
	
	// Lazy-> solo los carga cuando utilice los datos.
	@OneToMany(mappedBy="claseProfesor")
	private List<ProfesorEntity> profesores = new ArrayList<ProfesorEntity>();

	@OneToMany(mappedBy="claseAsignatura")
	private List<AsignaturaEntity> asignaturas = new ArrayList<AsignaturaEntity>();
	
	
}

