package proyecto.prueba.ejercicio1.mavenProyect0.dto;
import lombok.Getter;
import lombok.Setter;
import java.awt.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@Setter
@Getter
@XStreamAlias("Clase")
public class Clase {
		
		private Profesor profesor;
		
		private List listaAlumnos;
		
		

}

 