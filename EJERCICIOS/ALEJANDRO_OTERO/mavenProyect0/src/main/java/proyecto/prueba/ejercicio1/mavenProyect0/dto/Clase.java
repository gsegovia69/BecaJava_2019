package proyecto.prueba.ejercicio1.mavenProyect0.dto;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XStreamAlias("clase")
public class Clase {
		
		private Profesor profesor;
		
		@XStreamAlias("alumnos")
		private List <Alumno> listaAlumnos;
		
		
		

}

 