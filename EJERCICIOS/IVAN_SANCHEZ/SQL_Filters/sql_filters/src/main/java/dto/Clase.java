package dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity

public class Clase {
	@Id
	@GeneratedValue
	private int id;
	private String nombre;

	
	@OneToMany(mappedBy = "claseAlumno")
	private Set<Alumno> alumnos = new HashSet<Alumno>();

	@OneToMany(mappedBy = "claseProfesor")
	private Set<Asignatura> asignaturas = new HashSet<Asignatura>();
	
	@OneToMany(mappedBy = "claseAsignatura")
	private Set<Profesor> profesores = new HashSet<Profesor>();

}
