package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "alumno")
@Getter
@Setter
@ToString
//@XStreamAlias("alumno")
public class Alumno {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long idAlumno;
	@Column(name = "nombre")
	private String nombreAlumno;
	@Column(name = "apellidos")
	private String apellidosAlumno;
	@Column(name = "email")
	private String emailAlumno;
	@Column(name = "ciudad")
	private String ciudadAlumno;
	



}
