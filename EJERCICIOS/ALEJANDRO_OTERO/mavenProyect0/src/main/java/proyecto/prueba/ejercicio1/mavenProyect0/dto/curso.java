package proyecto.prueba.ejercicio1.mavenProyect0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name ="Clase")

public class curso {

	@Id
	@GeneratedValue
	@Column(name="idClase")
	private int idClase;
	@Column(name="nombreClase")
	private String nombreClase;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="claseAlumno")
	private Set(Alumno) alumnos = new HashSet<ALumno>();
	
	
	
	
}
