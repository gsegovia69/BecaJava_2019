package com.everis.java.formacion.mavenProject1.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@XStreamAlias("alumno")
@ToString
public class Alumno {
	
	private String nombre;
	private String apellidos;
	private String email;
	private String ciudad;
}
