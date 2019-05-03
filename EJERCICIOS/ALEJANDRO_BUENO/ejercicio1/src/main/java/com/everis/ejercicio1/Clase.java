package com.everis.ejercicio1;

import java.util.List;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XStreamAlias("clase")

public class Clase 
{
	@XStreamAlias("alumnos")
	private List<Alumno> listaAlumnos;
}
