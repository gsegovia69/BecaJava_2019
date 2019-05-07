package com.everis.beca.BaseDeDatos.dto;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase Alumno
 *@author Alejandro Jimenez
 *@version 03.05.2019
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="alumno")
public class Alumno {
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="email")
	private String email;
	
	@Column(name="ciudad")
	private String ciudad;
	
	@Column(name="id_clase")
	private int id_clase;
	
}