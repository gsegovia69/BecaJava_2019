package com.everis.beca.java.mavenProyect1.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XStreamAlias("alumno")
public class Alumno {
	
	private String nombre;
	private String apellidos;
	private String email;
	@XStreamAlias("ciudad")
	private String ciudades;	
}
