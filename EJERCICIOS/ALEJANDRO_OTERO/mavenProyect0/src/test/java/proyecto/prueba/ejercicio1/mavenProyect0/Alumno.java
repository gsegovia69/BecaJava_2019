package proyecto.prueba.ejercicio1.mavenProyect0;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@XStreamAlias("alumno")
@Getter
@Setter
@ToString

public class Alumno {
	public String nombre;
	public String apellidos;
	public String email;
	public String ciudad;
}


	