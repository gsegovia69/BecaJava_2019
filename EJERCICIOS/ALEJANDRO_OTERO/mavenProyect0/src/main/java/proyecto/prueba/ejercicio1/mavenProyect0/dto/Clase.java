package proyecto.prueba.ejercicio1.mavenProyect0.dto;
import java.awt.List;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter

@XStreamAlias("clase")

public class Clase {
		
		private Profesor profesor;
		
		private List listaAlumnos;
		
		

}

 