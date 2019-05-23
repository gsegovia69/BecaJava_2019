package paramo.de.la.programacion.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ClaseDTO {

	private int id;

	private String nombre;

	private Set<AlumnoDTO> alumnos = new HashSet<AlumnoDTO>();

	private Set<ProfesorDTO> profesores = new HashSet<ProfesorDTO>();

	private Set<AsignaturaDTO> asignaturas = new HashSet<AsignaturaDTO>();

}
