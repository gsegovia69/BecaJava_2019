package com.everis.beca.ejercicios.dto;


import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase Profesor
 * @author Alejandro Jim�nez
 *@version 03.05.2019
 */
@XStreamAlias("profesor")
@Getter
@Setter
@NoArgsConstructor
@ToString
 class Profesor {
	
	private String nombre;
	
	private String apellidos;
	
	private String email;
	
	private String ciudad;
	
}
