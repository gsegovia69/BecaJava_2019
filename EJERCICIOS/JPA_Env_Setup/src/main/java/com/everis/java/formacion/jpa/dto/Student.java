package com.everis.java.formacion.jpa.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "alumno")
public class Student {

	@Id
	@GeneratedValue
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

	//@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "id_clase")
	private Curso cursoAlumno;

}
