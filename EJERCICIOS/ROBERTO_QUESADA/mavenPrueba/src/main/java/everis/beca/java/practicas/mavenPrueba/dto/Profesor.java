package everis.beca.java.practicas.mavenPrueba.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
@Table(name = "profesor")

public class Profesor {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "email")
	private String email;
	@Column(name = "ciudad")
	private String ciudad;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_clase")
	private Clase id_clase;
}
