package com.everis.beca.java.conexionBaseDatos.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity

public class Profesor {

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
	private String ciudadPRofesor;
	
	@ManyToOne
	@JoinColumn(name = "id_clase")
	private Clase claseProfesor;
	
}
