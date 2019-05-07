package com.everis.beca.BaseDeDatos.dto;



import javax.persistence.Entity;
import javax.persistence.Id;
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
	
	@Id
	private int id;
	
	private String nombre;

	private String apellidos;

	private String email;

	private String ciudad;
	
	private int id_clase;
	
}