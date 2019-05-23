package paramo.de.la.programacion.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AlumnoDTO {

	private Long id;

	private String nombre;

	private String apellidos;

	private String email;

	private String ciudad;
	
	private int idCurso;
	
	private String nombreCurso;
	
	private List<ClaseDTO> cursos;

	private ClaseDTO idClase;

}
