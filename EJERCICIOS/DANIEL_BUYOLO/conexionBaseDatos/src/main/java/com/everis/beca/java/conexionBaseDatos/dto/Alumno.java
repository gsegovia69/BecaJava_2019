package com.everis.beca.java.conexionBaseDatos.dto;



import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Alumno {

	private int id;
	private String nombre;
	private String apellidos;
	private String email;
	private String ciudades;
	private int id_clase;
	
}
