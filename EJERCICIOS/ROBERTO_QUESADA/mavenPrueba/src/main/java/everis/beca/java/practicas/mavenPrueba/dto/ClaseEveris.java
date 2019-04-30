package everis.beca.java.practicas.mavenPrueba.dto;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@XStreamAlias("clase")
@Setter
@Getter


public class ClaseEveris {
	private Profesor profesor;
	@XStreamAlias("alumnos")
	private List<Alumno> ListaAlumnos;
}
