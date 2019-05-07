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
@ToString
@Entity

public class Profesor {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int idProfesor;
	private String nombre;
	private String apellidos;
	private String email;
	private String ciudades;
	
	@ManyToOne
	@JoinColumn(name = "id_clase")
	private Clase claseProfesor;
	
}
