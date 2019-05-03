package com.everis.jaime.mavenJaime2.dto;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@XStreamAlias("clase")
public class ClaseProfesorAlumnos2 {
	private Profesor2 profesor; 
	@XStreamAlias("alumnos")
	private List<Alumno2> listaAlumnos;
	

}
