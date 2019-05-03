package com.everis.beca.ejercicios.dto;


import java.util.List;


import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@XStreamAlias("clase")

public class Clase {

	private Profesor profesor;
	@XStreamAlias("alumnos")
	private List<Alumno> listaAlumnos;
	
}
