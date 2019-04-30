package com.everis.beca.java.mavenProyect1.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XStreamAlias("profesor")
public class Profesor {
	private String nombre;
	private String apellidos;
	private String email;
	@XStreamAlias("ciudad")
	private String ciudades;
}
