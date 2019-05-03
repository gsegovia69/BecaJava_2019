package com.everis.formacion.mavenProject1.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@Setter
@Getter
@ToString
@XStreamAlias("clase")
public class Clase {
	private Profesor profesor;
	@XStreamAlias("alumnos")
	private List<Alumno> listaAlumnos;

}


