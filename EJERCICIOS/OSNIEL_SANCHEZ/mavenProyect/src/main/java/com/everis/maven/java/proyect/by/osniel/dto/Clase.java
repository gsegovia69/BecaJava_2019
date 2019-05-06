package com.everis.maven.java.proyect.by.osniel.dto;

import java.util.ArrayList;
import java.util.List;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@XStreamAlias("clase")
public class Clase {
	
	String id;
	String nombre;
	Profesor profesor;
	@XStreamAlias("alumnos")
	List<Alumno> alumnos = new ArrayList<Alumno>();

	public Clase() {
	}
}


