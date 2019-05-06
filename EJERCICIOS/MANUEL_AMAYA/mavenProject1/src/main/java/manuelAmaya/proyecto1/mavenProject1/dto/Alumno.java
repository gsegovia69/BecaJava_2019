package manuelAmaya.proyecto1.mavenProject1.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@XStreamAlias("alumno")
@ToString
public class Alumno {
	private String nombre; 
	private String apellidos;
	private String email;
	@XStreamAlias("ciudad")
	private String ciudades;
	
	public String getApellidos2() { return apellidos.toUpperCase(); }
}
