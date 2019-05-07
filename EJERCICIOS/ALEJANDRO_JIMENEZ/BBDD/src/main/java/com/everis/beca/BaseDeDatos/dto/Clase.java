package com.everis.beca.BaseDeDatos.dto;


import java.util.List;


import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter

public class Clase {

	private Profesor profesor;
	private List<Alumno> listaAlumnos;
	
}
