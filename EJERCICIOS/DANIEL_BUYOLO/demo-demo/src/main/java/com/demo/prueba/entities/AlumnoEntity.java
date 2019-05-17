package com.demo.prueba.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alumno")
public class AlumnoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int idAlumno;
	@Column(name = "nombre")
	private String nombreAlumno;
	@Column(name = "apellidos")
	private String apellidosAlumno;
	@Column(name = "email")
	private String emailAlumno;
	@Column(name = "ciudad")
	private String ciudadAlumno;
	
	@ManyToOne
	@JoinColumn(name = "id_clase")
	private ClaseEntity claseAlumno;
	
}

