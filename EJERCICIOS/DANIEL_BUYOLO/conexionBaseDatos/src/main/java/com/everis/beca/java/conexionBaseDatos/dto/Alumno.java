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
public class Alumno {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int idAlumno;
	private String nombre;
	private String apellidos;
	private String email;
	private String ciudad;
	
	@ManyToOne
	@JoinColumn(name = "id_clase")
	private Clase claseAlumno;
	
}
