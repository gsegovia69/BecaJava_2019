package proyecto.prueba.ejercicio1.mavenProyect0.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="Asignatura")


public class Asignatura {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="orden")
	private String orden;
	
	@ToString.Exclude
	@ManytoOne(Cascade = CascadeType.ALL)
	@JoinColumn(name ="id_clase")
	private Clase clase ;
	

}
