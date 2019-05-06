package manuelAmaya.proyecto1.mavenProject1.dto;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@XStreamAlias("clase")
@ToString
public class Clase {
	private Profesor profesor;
	@XStreamAlias("alumnos")
	private List<Alumno> listaAlumnos;
}
