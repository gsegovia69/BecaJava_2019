package com.everis.java.formacion.jpa.dto;

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

@Getter
@Setter
@ToString
@Entity
@Table(name = "clase")
public class Curso {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int idClase;

	@Column(name = "nombre")
	private String nombreClase;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="cursoAlumno")
	private Set<Student> students = new HashSet<Student>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy="cursoProfesor")
	private Set<Teacher> profesores = new HashSet<Teacher>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy="cursoAsignatura")
	private Set<Asignatura> asignaturas = new HashSet<Asignatura>();
}
