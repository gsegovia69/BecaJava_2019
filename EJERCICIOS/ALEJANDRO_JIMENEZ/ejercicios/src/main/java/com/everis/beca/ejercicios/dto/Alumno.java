package com.everis.beca.ejercicios.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase Alumno
 * @author Alejandro Jimenez
 *@version 03.05.2019
 */
@XStreamAlias("alumno")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Alumno {
	
	private String nombre;
	
	private String apellidos;
	
	private String email;
	
	private String ciudad;
	
}