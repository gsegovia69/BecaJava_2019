package com.demo.prueba.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "profesor")
public class ProfesorEntity {

	@Id
	@GeneratedValue
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
	
	@ManyToOne
	@JoinColumn(name = "id_clase")
	private ClaseEntity claseProfesor;
	
}