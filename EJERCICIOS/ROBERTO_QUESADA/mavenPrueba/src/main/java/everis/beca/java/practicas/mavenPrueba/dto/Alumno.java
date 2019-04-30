package everis.beca.java.practicas.mavenPrueba.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Setter
@Getter
@XStreamAlias("alumno")

public class Alumno {
	private String nombre;
	
	private String apellidos;
	
	private String email;
	
	private String ciudad;
	
	public String allString() {
		return nombre + " " + apellidos + " //////////// Ciudad: " + ciudad + " //////////// Email: " + email; 
	}
}




