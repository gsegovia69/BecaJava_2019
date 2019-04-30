package com.everis.java.formacion.mavenProject1.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@XStreamAlias("profesor")
@ToString
public class Profesor {
	
	private String nombre;
	private String apellidos;
	private String email;
	private String ciudad;
}
