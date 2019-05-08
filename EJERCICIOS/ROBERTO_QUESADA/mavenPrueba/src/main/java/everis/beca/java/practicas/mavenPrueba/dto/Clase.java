package everis.beca.java.practicas.mavenPrueba.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table( name = "clase")

public class Clase {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "id_clase")
	private Set<Alumno> alumnos = new HashSet<Alumno>();
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "id_clase")
	private Set<Profesor> profesores = new HashSet<Profesor>();
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "id_clase")
	private Set<Asignatura> asignaturas = new HashSet<Asignatura>();
	
}

