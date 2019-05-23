package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "Clase")
public class CursoEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nombre")
	private String nombre;

	// Relacionamos cada una de las clases con la clase curso
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "idCurso")
	private Set<AlumnoEntity> alumnos = new HashSet<AlumnoEntity>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "idCurso")
	private Set<ProfesorEntity> profesor = new HashSet<ProfesorEntity>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "idCurso")
	private Set<AsignaturaEntity> asignaturas = new HashSet<AsignaturaEntity>();
}
