package com.everis.java.formacion.jpa.dto;

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
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "profesor")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int idProfesor;
	@Column(name = "nombre")
	private String nombreProfesor;
	@Column(name = "apellidos")
	private String apellidosProfesor;
	@Column(name = "email")
	private String emailProfesor;
	@Column(name = "ciudad")
	private String ciudadProfesor;

	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "id_clase")
	private Curso cursoProfesor;


}
